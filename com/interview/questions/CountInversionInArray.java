package com.interview.questions;

import java.util.Arrays;
import java.util.Stack;

public class CountInversionInArray {

	// Two elements form an inversion if a[i] > a[j], where i < j.

	public static int inversionBySimpleMethod(int[] arr) {

		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] > arr[j])
					count++;
			}
		}

		return count;

	}

	// using merge sort
	public static int countInversion(int[] arr) {

		return mergeAndCount(arr, 0, arr.length - 1);

	}

	public static int mergeAndCount(int[] arr, int low, int high) {

		int count = 0;

		if (low >= high) {
			return count;
		}

		int mid = (low + high) / 2;

		count += mergeAndCount(arr, low, mid);
		count += mergeAndCount(arr, mid + 1, high);

		count += merge(arr, low, mid, high);

		return count;
	}

	public static int merge(int[] arr, int low, int mid, int high) {

		int count = 0;

		int[] left = Arrays.copyOfRange(arr, low, mid + 1);
		int[] right = Arrays.copyOfRange(arr, mid + 1, high + 1);

		int i = 0;
		int j = 0;

		int k = low;

		while (i < left.length && j < right.length) {

			if (left[i] < right[j]) {
				arr[k] = left[i];
				k++;
				i++;
			} else {

				count += left.length - i;
				arr[k] = right[j];
				k++;
				j++;
			}
		}

		while (i < left.length) {
			arr[k] = left[i];
			k++;
			i++;
		}

		while (j < right.length) {
			arr[k] = right[j];
			k++;
			j++;

		}

		return count;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 20, 6, 4, 5 };
		int[] arr1 = {8, 4, 2, 1};

		System.out.println("Inversion Count : " + inversionBySimpleMethod(arr));
		System.out.println(countInversion(arr));
		System.out.println(countInversion(arr1));
	}
}
