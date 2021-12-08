package com.interview.arrays;

/**
 * Given an array of 0’s and 1’s, we need to write a program to find the minimum
 * number of swaps required to group all 1’s present in the array together.
 * 
 * @author gauravarora02
 *
 */
public class MinSwapsToGroupOnes {

	public static void main(String[] args) {

		int arr[] = { 1, 0, 1, 0, 1 };
		int arr1[] = { 1, 0, 1, 0, 1, 1 };

		System.out.println(minSwaps(arr));
		System.out.println(minSwaps(arr1));
	}

	// Using sliding window technique
	public static int minSwaps(int[] arr) {

		int ans = 0;

		// 1. Count number of ones in the array
		int totalOnes = 0;
		for (int num : arr) {
			if (num == 1) {
				totalOnes++;
			}
		}

		// 2. Find the max number of ones in first window of size totalOnes
		int onesInCurrentWindow = 0;
		for (int i = 0; i < totalOnes; i++) {

			if (arr[i] == 1) {
				onesInCurrentWindow++;
			}
		}

		// 3. Slide the window to find subarray with max ones
		int maxOnes = onesInCurrentWindow;
		for (int i = 1; i < arr.length - totalOnes + 1; i++) {

			// first collapse window from left
			if (arr[i - 1] == 1) {
				onesInCurrentWindow--;
			}

			// then expand second window
			if (arr[i + totalOnes - 1] == 1) {
				onesInCurrentWindow++;
			}

			maxOnes = Math.max(maxOnes, onesInCurrentWindow);

		}

		ans = totalOnes - maxOnes;

		return ans;
	}
}
