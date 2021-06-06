package com.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithSumEqualK {

	public static int findSubArray(int[] arr, int k) {

		int count = 0;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		for (int i = 0; i < arr.length; i++) {

			sum += arr[i];

			if (map.containsKey(sum - k)) {

				count += map.get(sum - k);
			}

			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return count;
	}

	public static void main(String[] args) {

		int[] arr = { 3, 9, -2, 4, 1, -7, 2, 6, -5, 8, -3, -7, 6, 2, 1 };
		int k = 5;

		System.out.println("Total Sub array with sum " + k + " are " + findSubArray(arr, k));
	}
}
