package com.interview.recursion;

public class CheckIfArrayIsSorted {

	// given an array, check if the array is sorted using recursion

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4 };
		boolean sorted = checkIfSorted(arr, 0);

		System.out.println(sorted);

	}

	private static boolean checkIfSorted(int[] arr, int index) {

		if (index == arr.length - 1) {
			return true;
		}

		boolean isSorted = false;

		if (arr[index] < arr[index + 1]) {

			isSorted = checkIfSorted(arr, index + 1);
		}

		return isSorted;

	}
}
