package com.interview.hashing;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWith0Sum {

	// finds the largest sub array whose sum is 0 using hashing

	public static int getSubArrayLength(int[] arr) {

		Map<Integer, Integer> map = new HashMap<>();

		int length = 0;
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {

			sum = sum + arr[i];

			if (sum == 0)
				length = i + 1;

			// look this sum in the hash table
			Integer prevInt = map.get(sum);

			// If this sum is seen before, then update max_len
			// if required
			if (prevInt != null)
				length = Math.max(length, i - prevInt);
			else // Else put this sum in hash table
				map.put(sum, i);

		}

		return length;

	}

	public static void main(String[] args) {

		int[] arr1 = { 15, -2, 2, -8, 1, 7, 10, 23 };
		int[] arr2 = { 1, 2, 3 };
		int[] arr3 = { -1, 0, 1, 3 };
		int[] arr4 = { -1, -2, 3, 15, -8, 1, 7, 10, 13 };
		int[] arr5 = { 2, 0, 1, 3 };

		System.out.println("Length of largest sub array : " + getSubArrayLength(arr1));
		System.out.println("Length of largest sub array : " + getSubArrayLength(arr2));
		System.out.println("Length of largest sub array : " + getSubArrayLength(arr3));
		System.out.println("Length of largest sub array : " + getSubArrayLength(arr4));
		System.out.println("Length of largest sub array : " + getSubArrayLength(arr5));

	}
}
