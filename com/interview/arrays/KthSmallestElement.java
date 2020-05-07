package com.interview.arrays;

public class KthSmallestElement {

	public static int heapSort(int[] arr, int k) {

		int size = arr.length;

		// Build the min heap from array
		for (int i = size / 2 - 1; i >= 0; i--) {
			heapify(arr, i, size);
		}

		for (int i = size - 1; i >= size - k; i--) {

			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify(arr, 0, i);
		}

		return arr[size - k];

	}

	public static void heapify(int[] arr, int i, int size) {

		int smallest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < size && arr[left] < arr[smallest])
			smallest = left;

		if (right < size && arr[right] < arr[smallest])
			smallest = right;

		if (smallest != i) {

			// swap element at largest with element at i
			int temp = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = temp;

			heapify(arr, smallest, size);
		}
	}

	public static void main(String[] args) {

		int[] arr = { 7, 10, 4, 3, 20, 15 };
		int k = 2;

		long start = System.currentTimeMillis();

		System.out.println(k + "th smallest element is : " + heapSort(arr, k));

		long end = System.currentTimeMillis();

		System.out.println("Time taken : " + (end - start));

		for (int i : arr) {
			System.out.print(i + " ");
		}
		
	}

}
