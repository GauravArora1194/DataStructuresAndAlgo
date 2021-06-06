package com.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumDivisibleByK {

	public static int findLongestLength(int[] arr, int k) {

		int sum = 0;
		int remainder = 0;
		int maxLength = 0;

		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);

		for (int i = 0; i < arr.length; i++) {

			sum += arr[i];
			remainder = sum % k;

			if (remainder < 0) {
				remainder += k;
			}

			if (map.containsKey(remainder)) {

				int index = map.get(remainder);
				int length = i - index;

				if (length > maxLength) {
					maxLength = length;
				}
			} else {
				map.put(remainder, i);
			}

		}

		return maxLength;

	}

	public static void main(String[] args) {

		int[] arr = { -3, -9, -4, 8, 5, 4, 2, 6 };
		int k = 7;

		System.out.println("Longest sub array length : " + findLongestLength(arr, k));

	}

}
