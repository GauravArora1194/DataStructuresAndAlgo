package com.interview.dynamic.programming;

public class MinimumJumpToReachEnd {

	// finds the minimum jumps needed to reach the end of an array starting from 1st
	// index.

	public static int findMinJumps(int[] arr) {

		int[] minJumpArr = new int[arr.length];

		minJumpArr[0] = 0;

		for (int i = 1; i < arr.length; i++) {

			for (int j = 0; j < i; j++) {

				if (i <= j + arr[j]) {

					if (minJumpArr[i] != 0) {

						minJumpArr[i] = Math.min(minJumpArr[i], minJumpArr[j] + 1);
					} else {
						minJumpArr[i] = minJumpArr[j] + 1;
					}

				}
			}
		}

		return minJumpArr[arr.length - 1];

	}

	// Complexity - O(n)
	public static int minJumpsOptimized(int[] arr) {

		if (arr.length <= 1) {
			return 0;
		}

		if (arr[0] == 0) {
			return -1;
		}

		int maxReach = arr[0];
		int step = arr[0];
		int jumps = 1;

		for (int i = 1; i < arr.length; i++) {

			if (i == arr.length - 1) {
				return jumps;
			}

			maxReach = Math.max(maxReach, i + arr[i]);
			step--;

			if (step == 0) {
				jumps++;

				if (i >= maxReach) {
					return -1;
				}

				step = maxReach - i;
			}
		}

		return -1;

	}

	public static void main(String[] args) {

		int[] arr = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		int[] arr1 = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };

		System.out.println("Minimum Jump needed : " + findMinJumps(arr));
		System.out.println("Minimum Jump needed : " + findMinJumps(arr1));
		
		System.out.println("Minimum Jump needed : " + minJumpsOptimized(arr));
		System.out.println("Minimum Jump needed : " + minJumpsOptimized(arr1));

	}

}
