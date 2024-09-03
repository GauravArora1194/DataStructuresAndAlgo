package com.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class CountOfSubArraysWithEqual0And1 {

	public static int getCount(int[] arr) {

		int count = 0;
		int sum = 0;

		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		for (int val : arr) {

			if (val == 0) {
				sum += -1;
			} else {
				sum += 1;
			}

			if (map.containsKey(sum)) {
				count += map.get(sum);
				map.put(sum, map.get(sum) + 1);

			} else {
				map.put(sum, 1);
			}
		}

		return count;

	}

	public static void main(String[] args) {

	}

}
