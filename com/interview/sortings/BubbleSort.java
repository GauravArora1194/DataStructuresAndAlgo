package com.interview.sortings;

public class BubbleSort {

	public static void main(String[] args) {

		int[] arr = { 5, 4, 3, 2, 1 };

		bubbleSort(arr);

		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	private static void bubbleSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {

			for (int j = 0; j < arr.length - i; j++) {

				if (arr[j] > arr[j + 1]) {

					swap(arr, j);
				}
			}
		}
	}

	private static void swap(int[] arr, int j) {
		int temp = arr[j];
		arr[j] = arr[j + 1];
		arr[j + 1] = temp;
	}

}
