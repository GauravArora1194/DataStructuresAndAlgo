package com.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithSum0 {

	public static int findLargestSubArray(int[] arr) {

		int sum = 0;
		int maxLength = 0;

		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);

		for (int i = 0; i < arr.length; i++) {

			sum += arr[i];

			if (map.containsKey(sum)) {
				int index = map.get(sum);
				int length = i - index;

				if (length > maxLength) {
					maxLength = length;
				}
			} else {
				map.put(sum, i);
			}
		}

		return maxLength;

	}

	public static void main(String[] args) {

		int[] arr = { 2, 8, -3, -5, 2, -4, 6, 1, 2, 1, -3, 4 };

		System.out.println("Largest sub array with sum 0 is " + findLargestSubArray(arr));
	}

}
