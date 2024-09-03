package com.interview.sortings;

public class InsertionSort {

	public static void main(String[] args) {

		int[] arr = { 12, 11, 13, 5, 6, 15, 1 };

		int[] newArr = insertionSort(arr);

		for (int i : newArr) {
			System.out.print(i + " ");
		}

	}

	public static int[] sort(int[] arr) {

		int key, j;
		for (int i = 1; i < arr.length; i++) {

			key = arr[i];
			for (j = i - 1; j >= 0; j--) {

				if (key < arr[j]) {
					arr[j + 1] = arr[j];
				} else {
					break;
				}
			}

			arr[j + 1] = key;
		}

		return arr;
	}

	public static int[] insertionSort(int[] arr) {

		int journeyCounter = 1;

		while (journeyCounter <= arr.length - 1) {

			for (int i = journeyCounter; i > 0; i--) {

				if (arr[i] < arr[i - 1]) {

					swap(arr, i);

				} else {

					break;
				}
			}

			journeyCounter++;
		}

		return arr;
	}

	private static void swap(int[] arr, int i) {

		int temp = arr[i];
		arr[i] = arr[i - 1];
		arr[i - 1] = temp;
	}

}
