package com.interview.arrays;

public class BinarySearchInSortedAndRotatedArray {

	// Step1 - find index of the pivot (pivot is the element for which next element
	// is smaller than it).
	// Step2 - divide the array in two sub-arrays and apply binary search.

	// 3 4 5 6 1 2 -> index of 5

	public static int findPivot(int[] arr) {

		int beg = 0;
		int end = arr.length - 1;
		int mid = (beg + end) / 2;

		while (beg <= end && mid != arr.length - 1) {

			if (arr[mid] > arr[mid + 1])
				return mid;
			else if (arr[mid] >= arr[beg])
				beg = mid + 1;
			else
				end = mid - 1;

			mid = (beg + end) / 2;
		}

		return arr.length - 1;

	}

	public static int getPivot(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {

			if (arr[i + 1] < arr[i]) {
				return i;
			}

		}

		return 0;
	}

	public static int findElement(int[] arr, int data) {

		int pivot = findPivot(arr);

		int start = 0;
		int end = arr.length - 1;

		if (data == arr[pivot]) {
			return pivot;
		} else if (data >= arr[0] && data <= arr[pivot]) {
			// data is present is first sorted half
			end = pivot;
		} else {

			start = pivot + 1;
		}

		int mid = (start + end) / 2;
		while (start <= end) {

			if (data == arr[mid]) {
				return mid;
			} else if (data < arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}

			mid = (start + end) / 2;

		}

		return -1;

	}

	public static int findElementApproach2(int[] arr, int data) {

		int start = 0;
		int end = arr.length - 1;

		int mid = (start + end) / 2;

		while (start <= end) {

			if (data == arr[mid]) {
				return mid;
			} else if (arr[mid] >= arr[start]) {

				if (data >= arr[start] && data <= arr[mid])
					end = mid - 1;
				else
					start = mid + 1;

			} else {

				if (data >= arr[mid + 1] && data <= arr[end])
					start = mid + 1;
				else
					end = mid - 1;
			}

			mid = (start + end) / 2;
		}

		return -1;

	}

	public static void main(String[] args) {

		int arr[] = { 3, 4, 5, 6, 7, 8, 1, 2 };
		for (int i : arr) {
			System.out.print(i);
		}

		int pivot = getPivot(arr);

		System.out.println("Get pivot" + pivot);
		System.out.println("Find pivot " + findPivot(arr));

		System.out.println("Element is present at index : " + findElement(arr, 2));
		System.out.println("Approach 2 Element is present at index : " + findElementApproach2(arr, 2));

	}

}
