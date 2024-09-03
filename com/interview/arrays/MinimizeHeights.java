package com.interview.arrays;

import java.util.Arrays;

/**
 * Given an array arr[] denoting heights of N towers and a positive integer K,
 * you have to modify the height of each tower either by increasing or
 * decreasing them by K only once. After modifying, height should be a
 * non-negative integer. Find out what could be the possible minimum difference
 * of the height of shortest and longest towers after you have modified each
 * tower.
 * 
 * @author gauravarora02
 *
 */
public class MinimizeHeights {

	public static void main(String[] args) {

		int[] arr = { 1, 5, 8, 10 };

		System.out.println(getMinHeight(arr, 2));
	}

	public static int getMinHeight(int[] nums, int k) {

		Arrays.sort(nums);
		int length = nums.length;

		int ans = nums[length - 1] - nums[0];

		int largest = nums[length - 1] - k;
		int smallest = nums[0] + k;

		for (int i = 0; i < length - 1; i++) {

			int min = Math.min(smallest, nums[i + 1] - k);
			int max = Math.max(largest, nums[i] + k);

			ans = Math.min(ans, (max - min));
		}

		return ans;

	}

}
