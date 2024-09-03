package com.interview.dynamic.programming;

public class MaxSizeSquareSubMatrixMemoized {

	// Given an array with only 0 and 1 as entry. Find the max size square sub
	// matrix of 1's.

	static int overallMax = 0;
	static int overallRow = -1;
	static int overallCol = -1;

	public static void main(String[] args) {

		int[][] arr = {

				{ 1, 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1, 0 }

		};

		minSizeSquareSubMatrix(arr, 0, 0, new int[arr.length][arr[0].length]);

		System.out.println(overallMax + " @ [ " + overallRow + ", " + overallCol + " ]");
	}

	private static int minSizeSquareSubMatrix(int[][] arr, int srcRow, int srcCol, int[][] storage) {

		int destRow = arr.length - 1;
		int destCol = arr[0].length - 1;

		if (srcRow == destRow || srcCol == destCol) {

			return arr[srcRow][srcCol];
		}

		if (storage[srcRow][srcCol] != 0) {

			return storage[srcRow][srcCol];
		}

		if (arr[srcRow][srcCol] == 0) {
			return 0;
		} else {

			int minHorizontal = minSizeSquareSubMatrix(arr, srcRow, srcCol + 1, storage);
			int minvertical = minSizeSquareSubMatrix(arr, srcRow + 1, srcCol, storage);
			int minDiagonal = minSizeSquareSubMatrix(arr, srcRow + 1, srcCol + 1, storage);

			int result = 1 + Math.min(minDiagonal, Math.min(minvertical, minHorizontal));

			if (result > overallMax) {

				overallMax = result;
				overallRow = srcRow;
				overallCol = srcCol;
			}

			storage[srcRow][srcCol] = result;

			return result;

		}

	}

}
