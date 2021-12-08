package com.interview.arrays;

/**
 * Given an integer array nums, find a contiguous non-empty subarray within the
 * array that has the largest product, and return the product.
 * 
 * It is guaranteed that the answer will fit in a 32-bit integer.
 * 
 * A subarray is a contiguous subsequence of the array.
 * 
 * @author gauravarora02
 *
 */
public class MaximumProductSubArray {

	public static void main(String[] args) {

		int[] nums = { 2, 3, -2, 4 };

		System.out.println(maxProduct(nums));
	}

	public static int maxProduct(int[] nums) {

		int maxProduct = Integer.MIN_VALUE;
		int product = 1;

		// If the negative numbers are even, first pass will give the max product

		for (int i = 0; i < nums.length; i++) {

			product = product * nums[i];
			maxProduct = Math.max(maxProduct, product);

			if (product == 0) {
				product = 1;
			}
		}

		product = 1;

		for (int i = nums.length - 1; i >= 0; i--) {

			product = product * nums[i];
			maxProduct = Math.max(maxProduct, product);

			if (product == 0) {
				product = 1;
			}
		}

		return maxProduct;

	}
}
