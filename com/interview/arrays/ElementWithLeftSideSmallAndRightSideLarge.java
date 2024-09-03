package com.interview.arrays;

public class ElementWithLeftSideSmallAndRightSideLarge {

	// prints the elements where elements on its left side are smaller than it and
	// elements on its right side are greater than it.

	public static void printElement(int[] arr) {

		int[] leftMax = new int[arr.length];
		int[] rightMin = new int[arr.length];
		int count = 0;

		leftMax[0] = arr[0];
		rightMin[arr.length - 1] = arr[arr.length - 1];

		for (int i = 1; i < arr.length; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
		}

		for (int i = arr.length - 2; i >= 0; i--) {
			rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			if (leftMax[i] == rightMin[i]) {
				count++;
				System.out.println("Element " + arr[i] + " at index " + i + " satisfies the condition");
			}
		}

		if (count == 0) {
			System.out.println("No Element satisfies the condition!");
		}
	}

	public static void main(String[] args) {

		int[] arr = { 5, 1, 4, 3, 6, 8, 10, 7, 9 };
		int[] arr1 = { 1, 2, 3, 4, 5, 6 };
		int[] arr2 = { 5, 4, 3, 2, 1 };

		printElement(arr);
		printElement(arr1);
		printElement(arr2);
	}

}
