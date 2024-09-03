package com.interview.arrays;

public class SortNegativeAndPositiveNumbers {

	// sort negative and positive numbers such that negative numbers appears before
	// positive and also maintains the order.

	// eg. [1,7,-5,9,-12,15] -> [-5,-12,1,7,9,15]

	// expected time complexity O(n) and space complexity O(1)

	// with O(n) space
	public static void sortAndMaintainOrder(int[] arr) {

		int[] temp = new int[arr.length];

		int start = 0;
		int j = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > 0) {
				temp[start] = arr[i];
				start++;
			} else {
				arr[j] = arr[i];
				j++;
			}
		}

		for (int i = 0; i < start; i++) {

			arr[j] = temp[i];
			j++;
		}

		System.out.println("Modified array is : ");

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static void modifiedInsertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] < 0) {

				// sort arr[0] ... arr[i-1]
				int key = arr[i];
				int j = i - 1;

				for (; j >= 0 && arr[j] > 0; j--) {

					arr[j + 1] = arr[j];
				}

				arr[j + 1] = key;

			}

		}

		System.out.println();
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	public static void sortAndMaintainOrderOptimized(int[] arr) {

		// 1. Find the Max and Min in array
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}

		// 2. Add -min to all the elements of array so that array consist of only +ve
		// elements
		for (int i = 0; i < arr.length; i++) {
			arr[i] += -min;
		}

		// 3. Elements which are greater or equal to -min are +ve else -ve
		// Move the negative elements forward by adding (arr[i] % divisor)*divisor to
		// the elements from start.

		int divisor = max - min + 1;
		int k = 0;

		// First iterate for -ve elements
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] % divisor < -min) {
				arr[k] += (arr[i] % divisor) * divisor;
				k++;
			}
		}

		// Then for +ve elements
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] % divisor >= -min) {
				arr[k] += (arr[i] % divisor) * divisor;
				k++;
			}
		}

		// 4. Build the original array
		for (int i = 0; i < arr.length; i++) {

			arr[i] = arr[i] / divisor;
			arr[i] += min;
		}

		System.out.println();
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	public static void sortAlternatively(int[] arr) {

		// Use partition technique of quick sort and using 0 as pivot.

		int i = -1;
		int pivot = 0;

		for (int j = 0; j < arr.length; j++) {

			if (arr[j] < pivot) {

				i++;
				int temp = arr[j];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// first positive element is at index i+1;

		int negIndex = 0;
		int posIndex = i + 1;

		while (negIndex < posIndex) {

			// swap elements at posIndex and negIndex
			int temp = arr[posIndex];
			arr[posIndex] = arr[negIndex];
			arr[negIndex] = temp;

			posIndex += 1;
			negIndex += 2;
		}

		System.out.println();
		for (int num : arr) {
			System.out.print(num + " ");
		}

	}

	public static void main(String[] args) {

		int[] arr = { 1, 7, -5, 9, -12, 15 };
		// int[] arr = {-1,-2,-3,-5,-4};

		sortAndMaintainOrder(arr);
		modifiedInsertionSort(arr);
		sortAndMaintainOrderOptimized(arr);
		sortAlternatively(arr);
	}
}
