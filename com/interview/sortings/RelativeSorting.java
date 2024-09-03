package com.interview.sortings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class CustomComparator implements Comparator<Integer> {

	Map<Integer, Integer> map;

	public CustomComparator(Map<Integer, Integer> map) {
		this.map = map;
	}

	@Override
	public int compare(Integer x, Integer y) {

		if (map.containsKey(x) && map.containsKey(y))
			return map.get(x) - map.get(y);
		else if (map.containsKey(y))
			return 1;
		else if (map.containsKey(x))
			return -1;
		else
			return x - y;

	}

}

public class RelativeSorting {

	// sorts the array according to the order of elements in another array. if
	// elements are not present in second array than sorts according to their
	// natural order.

	// 1. Using Hashing

	// sorts arr1 relative to arr2
	public static void relativeSort(int[] arr1, int[] arr2) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr1.length; i++) {

			if (map.containsKey(arr1[i])) {
				map.put(arr1[i], map.get(arr1[i]) + 1);
			} else {
				map.put(arr1[i], 1);
			}
		}

		int j = 0;
		for (int i = 0; i < arr2.length; i++) {

			if (map.containsKey(arr2[i])) {

				int count = map.get(arr2[i]);

				while (count != 0) {
					arr1[j] = arr2[i];
					j++;
					count--;
				}

				map.remove(arr2[i]);

			}
		}

		if (!map.isEmpty()) {

			int[] temp = new int[map.size()];
			int k = 0;

			Set<Entry<Integer, Integer>> entries = map.entrySet();

			for (Entry<Integer, Integer> entry : entries) {

				temp[k] = entry.getKey();

				k++;
				// map.remove(entry.getKey());
			}

			Arrays.sort(temp);

			for (int i = 0; i < temp.length; i++) {
				arr1[j] = temp[i];
				j++;
			}
		}

	}

	// 2. using two loops

	public static void relativeSort2(Integer[] arr1, Integer[] arr2) {

		Arrays.sort(arr1);

		int k = 0;

		for (int i = 0; i < arr2.length; i++) {

			for (int j = 0; j < arr1.length; j++) {

				if (arr1[j] == arr2[i]) {

					// swap arr1[j] and arr1[k]
					int temp = arr1[j];
					arr1[j] = arr1[k];
					arr1[k] = temp;
					k++;
				}
			}
		}

		System.out.println("\nArray so far : ");
		for (int i : arr1) {
			System.out.print(i + " ");
		}
	}

	// 3. Using custom Comparator

	public static void relativeSort3(Integer[] arr1, Integer[] arr2) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr2.length; i++) {
			map.put(arr2[i], i);
		}

		// Arrays.sort method doesn't work with primitive array when used with user
		// defined comparator.
		// that's why we have to make arr1 and arr2 as Wrapper class.
		Arrays.sort(arr1, new CustomComparator(map));

	}

	public static void main(String[] args) {

		Integer[] arr1 = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8, 20, 4 };
		Integer[] arr2 = { 2, 1, 8, 3 };

		// relativeSort(arr1, arr2);

		// relativeSort3(arr1, arr2);

		System.out.println("Array after relative Sort : ");
		for (int i : arr1) {
			System.out.print(i + " ");
		}

		relativeSort2(arr1, arr2);
	}

}
