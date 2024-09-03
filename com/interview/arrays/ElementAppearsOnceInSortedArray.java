package com.interview.arrays;

public class ElementAppearsOnceInSortedArray {

	// finds the element that appears once in sorted array (other elements appear
	// twice)
	// complexity O(logn)

	public static int findElement(int[] arr) {

		int start = 0;
		int end = arr.length - 1;

		int mid = (start + end) / 2;

		while (start <= end) {

			if (start == end) {
				return arr[start];
			}

			if (mid % 2 == 0) {

				if (arr[mid] != arr[mid + 1]) {
					end = mid;
					mid = (start + end) / 2;
				} else {
					start = mid + 2;
					mid = (start + end) / 2;
				}

			} else {

				if (arr[mid] == arr[mid - 1]) {
					start = mid + 1;
					mid = (start + end) / 2;
				} else {
					end = mid - 1;
					mid = (start + end) / 2;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8 };
		int[] arr1 = { 1, 1, 3, 3, 4, 4, 5, 5, 7, 7, 8 };
		int[] arr2 = { 1, 1, 2, 2, 3, 3, 4, 5, 5 };
		int[] arr3 = { 1, 1, 2, 3, 3, 4, 4, 5, 5 };
		int[] arr4 = { 1, 1, 2, 2, 3, 3, 4, 4 };

		System.out.println("Unique element is : " + findElement(arr));
		System.out.println("Unique element is : " + findElement(arr1));
		System.out.println("Unique element is : " + findElement(arr2));
		System.out.println("Unique element is : " + findElement(arr3));
		System.out.println("Unique element is : " + findElement(arr4));
		
		int xor = arr[0];
		for(int i = 1; i < arr.length; i++) {
		
			xor = xor ^ arr[i];
		}
		
		System.out.println("XOR operation give " + xor);
	}

}
