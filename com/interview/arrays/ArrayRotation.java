package com.interview.arrays;

public class ArrayRotation {

	// 1234567 -> 3456712(d=2)
	// complexity- O(n)
	// Auxiliary space -O(n)
	public static int[] rotateByTempSpace(int[] arr, int rotAmt, int arrLen) {

		// creates a temporary array
		int[] tempArr = new int[arrLen];
		int j = 0;

		for (int i = rotAmt; i < arrLen; i++) {
			tempArr[j] = arr[i];
			j++;
		}

		for (int i = 0; i < rotAmt; i++) {
			tempArr[j] = arr[i];
			j++;
		}

		return tempArr;

	}

	// complexity - O(d*n)
	// Auxiliary space -O(1)
	public static int[] rotateByLeftShift(int[] arr, int rotAmt, int arrLen) {

		for (int i = 0; i < rotAmt; i++) {

			rotateLeft(arr, arrLen);

		}

		return arr;
	}

	public static void rotateLeft(int[] arr, int n) {

		int i;
		int temp = arr[0];
		for (i = 0; i < n - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[i] = temp;

	}

	/*
	 * Step1 - reverse array from index 0 to d-1. Step2 - reverse array from d to n.
	 * Step3 - reverse whole array.
	 * 
	 * Complexity - O(n)
	 */
	public static int[] rotateByReversal(int[] arr, int d, int n) {

		arrayReverse(arr, 0, d - 1);
		arrayReverse(arr, d, n - 1);
		arrayReverse(arr, 0, n - 1);

		return arr;
	}

	public static void arrayReverse(int[] arr, int start, int end) {

		while (start < end) {

			//int temp = arr[start];
			//arr[start] = arr[end];
			//arr[end] = temp;
			
			arr[start] = arr[start] + arr[end];
			arr[end] = arr[start] - arr[end];
			arr[start] = arr[start] - arr[end];
			start++;
			end--;

		}

	}

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 4, 5, 6, 7 };

		// int[] newArray = rotateByTempSpace(array, 6, array.length);
		// int[] newArray = rotateByLeftShift(array, 6, array.length);
		int[] newArray = rotateByReversal(array, 2, array.length);
		for (int i : newArray) {
			System.out.print(i);
		}

	}

}
