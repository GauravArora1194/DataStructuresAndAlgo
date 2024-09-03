package com.interview.arrays;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {

		// int[] arr1 = { 1, 5, 9, 10, 15, 20 };
		// int[] arr2 = { 2, 3, 8, 13 };

		int[] arr1 = { 10 };
		int[] arr2 = { 2, 3 };

		display(arr1);
		display(arr2);

		int[] mergedArray = merge(arr1, arr2);

		display(mergedArray);
	}

	// given two sorted array, this function merge the two arrays and return the new
	// sorted array
	public static int[] merge(int[] arr1, int[] arr2) {

		int i = 0, j = 0, k = 0;

		int[] result = new int[arr1.length + arr2.length];

		while (i < arr1.length && j < arr2.length) {

			if (arr1[i] < arr2[j]) {

				result[k] = arr1[i];
				i++;
			} else {

				result[k] = arr2[j];
				j++;
			}

			k++;

		}

		while (i < arr1.length) {

			result[k] = arr1[i];
			k++;
			i++;
		}

		while (j < arr2.length) {

			result[k] = arr2[j];
			k++;
			j++;
		}

		return result;

	}

	public static void display(int[] arr) {

		for (int i : arr) {

			System.out.print(i + " ");
		}

		System.out.println();
	}

}
