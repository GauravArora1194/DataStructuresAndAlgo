package com.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithEqual01And2 {

	public static int getLongestSize(int[] arr) {

		int maxLength = 0;
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;

		int delta10 = count1 - count0;
		int delta21 = count2 - count1;

		String key = delta10 + "#" + delta21;

		Map<String, Integer> map = new HashMap<>();
		map.put(key, -1);

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == 0) {
				count0++;
			} else if (arr[i] == 1) {
				count1++;
			} else {
				count2++;
			}

			delta10 = count1 - count0;
			delta21 = count2 - count1;
			key = delta10 + "#" + delta21;

			if (map.containsKey(key)) {
				int index = map.get(key);
				int length = i - index;

				if (length > maxLength) {
					maxLength = length;
				}
			} else {
				map.put(key, i);
			}
		}

		return maxLength;

	}

	public static void main(String[] args) {

		int[] arr = { 1, 1, 2, 0, 1, 0, 1, 2, 1, 2, 2, 0, 1 };

		System.out.println("Max Length sub array : " + getLongestSize(arr));
	}

}
