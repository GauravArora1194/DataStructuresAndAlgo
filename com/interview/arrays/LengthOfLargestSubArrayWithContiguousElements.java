package com.interview.arrays;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLargestSubArrayWithContiguousElements {

	public static void main(String[] args) {

	}

	// max - min == j - i, this condition should be valid for non duplicate elements
	public static int largestLength(int[] arr) {

		int maxLength = 0;

		for (int i = 0; i < arr.length - 1; i++) {

			int min = arr[i];
			int max = arr[i];
			Set<Integer> set = new HashSet<>();
			set.add(arr[i]);

			for (int j = i + 1; j < arr.length; j++) {

				if (set.contains(arr[j])) {
					break;
				}

				set.add(arr[j]);

				min = Math.min(min, arr[j]);
				max = Math.max(max, arr[j]);

				if (max - min == j - i) {

					int length = j - i + 1;

					if (length > maxLength) {
						maxLength = length;
					}
				}

			}
		}

		return maxLength;
	}
}
