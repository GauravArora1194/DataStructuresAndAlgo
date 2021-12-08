package com.interview.arrays.advanced;

/**
 * https://leetcode.com/problems/next-permutation/
 * 
 * @author gauravarora02
 *
 */
public class NextPermutation {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3 };

		nextPermutation(nums);
		
		for(int i : nums) {
			System.out.print(i + " ");
		}

	}

	public static void nextPermutation(int[] nums) {

		int i = nums.length - 2;

		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}

		if (i >= 0) {

			int j = nums.length - 1;

			while (nums[i] >= nums[j]) {
				j--;
			}
			swap(nums, i, j);
		}

		reverse(nums, i + 1);
	}

	public static void swap(int[] nums, int i, int j) {

		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void reverse(int[] nums, int startIndex) {

		int endIndex = nums.length - 1;

		while (startIndex < endIndex) {

			swap(nums, startIndex, endIndex);
			startIndex++;
			endIndex--;
		}
	}
}
