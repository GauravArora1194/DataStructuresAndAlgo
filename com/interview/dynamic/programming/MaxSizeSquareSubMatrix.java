package com.interview.dynamic.programming;

public class MaxSizeSquareSubMatrix {

	// Given an array with only 0 and 1 as entry. Find the max size square sub
	// matrix of 1's.

	public static void main(String[] args) {

		int[][] arr = {

				{ 1, 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1, 0 }

		};

		maxSizeSquareSubMatrix(arr);

	}

	private static void maxSizeSquareSubMatrix(int[][] arr) {

		int destRow = arr.length - 1;
		int destCol = arr[0].length - 1;

		int overallMax = 0;
		int overallRow = -1;
		int overallCol = -1;

		int[][] storage = new int[destRow + 1][destCol + 1];

		for (int row = destRow; row >= 0; row--) {

			for (int col = destCol; col >= 0; col--) {

				if (row == destRow && col == destCol) {
					// last cell
					storage[row][col] = arr[row][col];
				} else if (row == destRow) {
					// last row except last cell
					storage[row][col] = arr[row][col];
				} else if (col == destCol) {
					// last column except last cell
					storage[row][col] = arr[row][col];
				} else {
					if (arr[row][col] == 0) {
						storage[row][col] = 0;
					} else {

						storage[row][col] = 1 + Math.min(storage[row + 1][col + 1],
								(Math.min(storage[row][col + 1], storage[row + 1][col])));
					}

				}

				if (storage[row][col] > overallMax) {

					overallMax = storage[row][col];
					overallRow = row;
					overallCol = col;
				}

			}
		}

		System.out.println(overallMax + " @ [ " + overallRow + ", " + overallCol + " ]");

	}
}
