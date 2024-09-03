package com.interview.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwapsToSortAnArray {

	public static void main(String[] args) {

		int[] arr = { 4, 3, 2, 1 };
		int[] arr1 = { 1, 5, 4, 3, 2 };
		
		System.out.println(minSwaps(arr));
		System.out.println(minSwaps(arr1));

		System.out.println(minSwapsUsingHashMap(arr));
		System.out.println(minSwapsUsingHashMap(arr1));
	}

	// Here the array is not modified
	public static int minSwaps(int[] arr) {

		int length = arr.length;

		Pair[] pairs = new Pair[length];

		for (int i = 0; i < length; i++) {
			pairs[i] = new Pair(arr[i], i);
		}

		Arrays.sort(pairs);

		int minSwaps = 0;
		boolean[] visited = new boolean[length];

		for (int i = 0; i < length; i++) {

			int swaps = 0;
			int j = i;

			if (visited[i] || i == pairs[i].getIndex())
				continue;

			while (visited[j] == false) {

				visited[j] = true;
				swaps++;
				j = pairs[j].getIndex();
			}

			minSwaps += swaps - 1;

		}

		return minSwaps;
	}

	// Here the array is modified
	public static int minSwapsUsingHashMap(int[] arr) {

		int length = arr.length;

		Map<Integer, Integer> map = new HashMap<>(length);

		for (int i = 0; i < length; i++) {
			map.put(arr[i], i);
		}

		Arrays.sort(arr);

		int minSwaps = 0;
		boolean[] visited = new boolean[length];

		for (int i = 0; i < length; i++) {

			if (visited[i] || i == map.get(arr[i]))
				continue;

			int swaps = 0;
			int j = i;
			while (visited[j] == false) {
				swaps++;
				visited[j] = true;
				j = map.get(arr[j]);
			}

			minSwaps += swaps - 1;

		}

		return minSwaps;
	}

}

class Pair implements Comparable<Pair> {

	private int value;
	private int index;

	public Pair(int value, int index) {
		super();
		this.value = value;
		this.index = index;
	}

	@Override
	public int compareTo(Pair o) {

		return (this.value > o.value) ? 1 : (this.value < o.value) ? -1 : 0;

	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
