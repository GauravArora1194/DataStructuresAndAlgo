package com.interview.arrays;

public class ReverseArrayInGivenGroup {

	public static void reverse(int[] arr, int start, int end) {

		if (end >= arr.length) {
			end = arr.length - 1;
		}

		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;

			start++;
			end--;
		}

	}

	public static void reverseArrayInGroup(int[] arr, int k) {

		for (int i = 0; i < arr.length;) {

			reverse(arr, i, i + k - 1);

			i += k;
		}
	}

	private static void displayArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		int k = 3;

		reverseArrayInGroup(arr, k);

		displayArray(arr);
	}

}
