package com.interview.arrays;

import java.util.Arrays;

/**
 * We are given two sorted arrays. We need to merge these two arrays such that
 * the initial numbers (after complete sorting) are in the first array and the
 * remaining numbers are in the second array. Extra space allowed in O(1).
 * 
 * @author gauravarora02
 *
 */
public class MergeTwoSortedArray {

	public static void main(String[] args) {

		int arr1[] = { 1, 5, 9, 10, 15, 20 };
		int arr2[] = { 2, 3, 8, 13 };

		display(arr1);
		display(arr2);
		merge(arr1, arr2);
		display(arr1);
		display(arr2);
		merge2(arr1, arr2);
		display(arr1);
		display(arr2);

	}

	public static void display(int[] arr) {

		System.out.println();
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}

	public static void merge(int[] arr1, int[] arr2) {

		for (int i = arr2.length - 1; i >= 0; i--) {

			// find the correct position of element arr2[i], either in arr1 or arr2.

			int last = arr1[arr1.length - 1];

			int j = arr1.length - 2;
			for (; j >= 0 && arr1[j] > arr2[i]; j--) {

				arr1[j + 1] = arr1[j];
			}

			if (j != arr1.length - 2 || last > arr2[i]) {

				arr1[j + 1] = arr2[i];
				arr2[i] = last;
			}
		}

	}

	public static void merge2(int[] arr1, int[] arr2) {

		int arr1Length = arr1.length;

		for (int i = 0; i < arr1Length && arr1[arr1Length - 1] > arr2[0]; i++) {

			if (arr1[i] > arr2[0]) {

				// swap elements and sort arr2

				int temp = arr1[i];
				arr1[i] = arr2[0];
				arr2[0] = temp;
				Arrays.sort(arr2);
			}
		}

	}
}
