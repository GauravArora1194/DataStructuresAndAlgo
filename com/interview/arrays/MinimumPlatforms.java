package com.interview.arrays;

import java.util.Arrays;

public class MinimumPlatforms {

	// Given arrival and departure times of all trains that reach a railway station,
	// find the minimum number of platforms required for the railway station so that
	// no train waits.

	// this approach is not right as only some cases are covered by this approach
	public static int findMin(int[] arr, int[] dep) {

		int platformNeeded = 1;

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] < dep[i - 1]) {
				platformNeeded++;
			}

		}

		return platformNeeded;

	}

	// This approach is right
	// 1.Sort both the array
	// 2.perform merge i.e if arrival increment platform else decrement
	// 3.find the max platform needed at any moment
	public static int findMinPlatform(int[] arr, int[] dep) {

		Arrays.sort(arr);
		Arrays.sort(dep);
		int maxPlatform = 0;
		int platformNeeded = 0;
		int i = 0;
		int j = 0;

		while (i < arr.length && j < dep.length) {

			if (arr[i] < dep[j]) {
				platformNeeded++;
				i++;
			} else {
				platformNeeded--;
				j++;
			}

			if (platformNeeded > maxPlatform) {
				maxPlatform = platformNeeded;
			}
		}

		return maxPlatform;
	}

	public static void main(String[] args) {

		int[] arrival = { 900, 940, 950, 1100, 1120, 1800 };
		int[] departure = { 910, 1200, 1120, 1130, 1900, 2000 };

		int[] arrival1 = { 100, 140, 150, 200, 215, 400 };
		int[] departure1 = { 110, 300, 220, 230, 315, 600 };

		int[] arrival2 = { 100, 110, 300, 220, 230, 315 };
		int[] departure2 = { 110, 300, 220, 230, 315, 600 };

		System.out.println("Minimum platform needed : " + findMinPlatform(arrival, departure));
		System.out.println("Minimum platform needed : " + findMinPlatform(arrival1, departure1));
		System.out.println("Minimum platform needed : " + findMinPlatform(arrival2, departure2));
	}
}
