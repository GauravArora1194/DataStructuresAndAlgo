package com.interview.questions;

public class ConvertArrayIntoZigZagFashion {

	public static void main(String[] args) {

		int[] arr = { 4, 3, 7, 8, 6, 2, 1 };
		// int[] arr = {1,4,3,2};
		boolean flag = false;
		int i = 0;
		while (i < arr.length - 1) {

			// first < comparison
			if (flag == false) {

				if (arr[i] > arr[i + 1]) {
					// swap
					swap(arr, i);
				}
			} else {
				// second > comparison
				if (arr[i] < arr[i + 1]) {
					// swap
					swap(arr, i);
				}
			}
			flag = !flag;
			i++;
		}

		for (int a : arr) {
			System.out.print(a + " ");
		}
	}

	private static void swap(int[] arr, int i) {
		
		int temp = arr[i];
		arr[i] = arr[i + 1];
		arr[i + 1] = temp;
	}
}
