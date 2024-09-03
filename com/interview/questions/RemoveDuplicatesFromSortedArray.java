package com.interview.questions;

public class RemoveDuplicatesFromSortedArray {

	public static int removeduplicate(int[] arr) {

		int j = 0;

		for (int i = 0; i < arr.length - 1; i++) {

			if (arr[i] != arr[i + 1]) {
				arr[j] = arr[i];
				j++;
			}

		}

		arr[j] = arr[arr.length - 1];

		return j + 1;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 2, 3, 3, 3, 4, 4 };

		int newArrLength = removeduplicate(arr);

		for (int i = 0; i < newArrLength; i++) {
			System.out.println(arr[i]);
		}
	}

}
