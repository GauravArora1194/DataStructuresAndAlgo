package com.interview.sortings;

import java.util.Arrays;

public class MergeSortWithOutExtraSpace {

	private static void mergeSort(int[] arr, int low, int high) {

		if (low >= high) {
			return;
		}

		int mid = (low + high) / 2;

		mergeSort(arr, low, mid);
		mergeSort(arr, mid + 1, high);

		merge(arr, low, mid, high);

	}

	private static void merge(int[] arr, int low, int mid, int high) {

		int[] left = Arrays.copyOfRange(arr, low, mid + 1);
		int[] right = Arrays.copyOfRange(arr, mid + 1, high + 1);

		int i = 0;
		int j = 0;
		int k = low;

		while (i < left.length && j < right.length) {

			if (left[i] < right[j]) {
				arr[k] = left[i];
				i++;
				k++;
			} else {
				arr[k] = right[j];
				k++;
				j++;
			}
		}

		while (i < left.length) {

			arr[k] = left[i];
			i++;
			k++;
		}

		while (j < right.length) {

			arr[k] = right[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args) {

		int[] arr = { 12, 11, 1, 13, 5, 6, 7, 34, 3, 0 };

		mergeSort(arr, 0, arr.length - 1);

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
