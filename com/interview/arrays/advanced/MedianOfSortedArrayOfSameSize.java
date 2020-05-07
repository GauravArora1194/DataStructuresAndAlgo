package com.interview.arrays.advanced;

public class MedianOfSortedArrayOfSameSize {

	public static void main(String[] args) {

		// int[] arr1 = { 1, 12, 15, 26, 38 };
		// int[] arr2 = { 2, 13, 17, 30, 45 };

		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 7, 8, 9, 10, 11 };

		int median = findMedian(arr1, arr2, 0, arr1.length - 1, 0, arr2.length - 1); // complexity - O(log n)
		int median1 = findMedianLinear(arr1, arr2, arr1.length); // complexity - O(n)

		System.out.println("Median  is : " + median);
		System.out.println("Median  using linear approach is : " + median1);

	}

	private static int findMedian(int[] arr1, int[] arr2, int si1, int ei1, int si2, int ei2) {

		if (si1 == ei1 && si2 == ei2) { // one element is present in each array

			return (arr1[si1] + arr2[si2]) / 2;
		}

		if (ei1 - si1 == 1 && ei2 - si2 == 1) { // Each array has two elements

			return (Math.max(arr1[si1], arr2[si2]) + Math.min(arr1[ei1], arr2[ei2])) / 2;
		}

		int m1 = getMedian(arr1, si1, ei1);
		int m2 = getMedian(arr2, si2, ei2);

		// case 1 : if m1 == m2
		if (m1 == m2)
			return m1;

		// case 2 : if m1 < m2
		else if (m1 < m2) {

			return findMedian(arr1, arr2, (ei1 + si1) / 2, ei1, si2, (ei2 + si2) / 2);

		} else {

			return findMedian(arr1, arr2, si1, (ei1 + si1) / 2, (ei2 + si2) / 2, ei2);
		}

	}

	private static int getMedian(int[] arr, int si, int ei) {

		int size = ei - si + 1;
		int mid = (ei + si) / 2;

		if (size % 2 == 0) {

			return (arr[mid] + arr[mid + 1]) / 2;

		} else {

			return arr[mid];
		}

	}

	private static int findMedianLinear(int[] arr1, int[] arr2, int size) {

		int m1 = -1;
		int m2 = -1;
		int i = 0, j = 0;

		for (int count = 0; count <= size; count++) {

			// all elements in array1 are smaller than array2.
			if (i == arr1.length) {

				m1 = m2;
				m2 = arr2[0];
				break;

			}

			// all elements in array2 are smaller than array1.
			if (j == arr2.length) {

				m1 = m2;
				m2 = arr1[0];
				break;

			}

			if (arr1[i] < arr2[j]) {

				m1 = m2;
				m2 = arr1[i];
				i++;

			} else {

				m1 = m2;
				m2 = arr2[j];
				j++;

			}
		}

		return (m1 + m2) / 2;

	}

}
