package com.interview.sortings;

//using the end element as Pivot
public class QuickSort {

	public static int partition(int[] arr, int start, int end) {

		int i = start - 1;
		int j = start;
		int pivot = arr[end];

		for (; j < end; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = pivot;
		arr[end] = temp;
		return i + 1;
	}

	public static void quickSort(int[] arr, int start, int end) {

		if (start >= end) {
			return;
		}

		int pivot = partition(arr, start, end);
		quickSort(arr, start, pivot - 1);
		quickSort(arr, pivot + 1, end);

	}

	public static void main(String[] args) {

		int[] arr = { 2, 1, 5, 6, 7, 5, 8 };
		quickSort(arr, 0, arr.length - 1);

		for (int i : arr) {
			System.out.println(i);
		}
	}

}
