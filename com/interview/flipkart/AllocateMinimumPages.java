package com.interview.flipkart;

/**
 * https://www.geeksforgeeks.org/allocate-minimum-number-pages/
 * 
 * @author gauravarora02
 *
 */
public class AllocateMinimumPages {

	public static void main(String[] args) {

		int pages[] = { 12, 34, 67, 90 };
		int m = 2;

		System.out.println(getMinNumberOfPages(pages, m));
	}

	public static int getMinNumberOfPages(int[] arr, int m) {

		int ans = -1;
		int sum = 0;

		for (int pages : arr) {
			sum += pages;
		}

		int start = 0;
		int end = sum;

		int mid = (start + end) / 2;

		while (start <= end) {

			if (isPossibleSolution(arr, m, mid)) {

				ans = mid;
				end = mid - 1;

			} else {
				start = mid + 1;
			}

			mid = (start + end) / 2;
		}

		return ans;
	}

	private static boolean isPossibleSolution(int[] arr, int m, int mid) {

		int studentCount = 1;
		int pageCount = 0;

		for (int i = 0; i < arr.length; i++) {

			if (pageCount + arr[i] <= mid) {

				pageCount += arr[i];

			} else {

				studentCount++;

				if (studentCount > m || arr[i] > mid) {
					return false;
				}

				pageCount = arr[i];
			}

		}

		return true;
	}
}
