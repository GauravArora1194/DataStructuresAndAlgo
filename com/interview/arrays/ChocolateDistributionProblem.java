package com.interview.arrays;

import java.util.Arrays;

public class ChocolateDistributionProblem {

	// Given an array of n integers where each value represents number of chocolates
	// in a packet. Each packet can have variable number of chocolates. There are m
	// students, the task is to distribute chocolate packets such that :

	// 1.Each student gets one packet.
	// 2.The difference between the number of chocolates in packet with maximum
	// chocolates and packet with minimum chocolates given to the students is
	// minimum.

	public static int getMinDifference(int[] arr, int m) {

		if (m == 0) {
			return 0;
		}

		int startIndex = 0;
		int endIndex = 0;
		int minValue = Integer.MAX_VALUE;

		Arrays.sort(arr);

		for (int i = 0; i < arr.length - m + 1; i++) {

			int start = i;
			int end = i + m - 1;

			if (arr[end] - arr[start] < minValue) {
				minValue = arr[end] - arr[start];
				startIndex = start;
				endIndex = end;
			}
		}

		System.out.println("Packets are distributed as follow : ");
		for (int i = startIndex; i <= endIndex; i++) {
			System.out.print(arr[i] + " ");
		}

		return minValue;
	}

	public static void main(String[] args) {

		int[] arr = { 7, 3, 2, 4, 9, 12, 56 };
		int m = 3;
		int[] arr1 = { 3, 4, 1, 9, 56, 7, 9, 12 };
		int n = 5;
		int[] arr2 = { 12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50 };
		int k = 7;

		System.out.println("\nMinimum Difference : " + getMinDifference(arr, m));
		System.out.println("\nMinimum Difference : " + getMinDifference(arr1, n));
		System.out.println("\nMinimum Difference : " + getMinDifference(arr2, k));
	}

}
