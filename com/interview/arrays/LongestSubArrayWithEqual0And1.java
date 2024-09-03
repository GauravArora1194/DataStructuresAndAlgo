package com.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithEqual0And1 {

	public static void main(String[] args) {

	}

	public static int longestSubArray(int[] arr) {

		int maxLength = 0;

		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);

		for (int i = 0; i < arr.length; i++) {

			sum += arr[i] == 0 ? -1 : arr[i];

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

}
