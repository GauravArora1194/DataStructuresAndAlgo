package com.interview.matrix;

import java.util.Arrays;

public class MedianInARowWiseSortedMatrix {

	public static void main(String[] args) {

		int m[][] = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };

		int m1[][] = { { 1, 3, 4 }, { 2, 5, 6 }, { 7, 8, 9 } };

		System.out.println(findMedian(m));
		System.out.println(findMedian(m1));
	}

	public static int findMedian(int[][] matrix) {

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		int rowLength = matrix.length;
		int colLength = matrix[0].length;

		for (int row = 0; row < matrix.length; row++) {

			if (matrix[row][0] < min) {
				min = matrix[row][0];
			}

			if (matrix[row][colLength - 1] > max) {
				max = matrix[row][colLength - 1];
			}
		}

		int desiredMedianIndex = (rowLength * colLength + 1) / 2;

		while (min < max) {

			int count = 0;
			int mid = min + (max - min) / 2;

			for (int row = 0; row < rowLength; row++) {

				int index = Arrays.binarySearch(matrix[row], mid);

				if (index < 0) {
					count += Math.abs(index) - 1;
				} else {
					count += index + 1;
				}
			}

			if (count < desiredMedianIndex) {
				min = mid + 1;
			} else {
				max = mid;
			}
		}

		return min;
	}
}
