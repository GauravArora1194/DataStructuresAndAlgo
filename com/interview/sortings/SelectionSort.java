package com.interview.sortings;

public class SelectionSort {

	public static void main(String[] args) {

		int[] arr = { 10, 15, 2, -1, 7 };

		int[] sortedArray = selectionSort(arr);

		for (int i : sortedArray) {
			
			System.out.print(i + " ");
		}
	}

	private static int[] selectionSort(int[] arr) {

		int jc = 1;

		while (jc <= arr.length - 1) {

			for (int i = jc; i < arr.length; i++) {

				if (arr[i] < arr[jc - 1]) {

					swap(arr, jc, i);
				}
			}

			jc++;
		}

		return arr;
	}

	private static void swap(int[] arr, int jc, int i) {

		int temp = arr[i];
		arr[i] = arr[jc - 1];
		arr[jc - 1] = temp;
	}

}
