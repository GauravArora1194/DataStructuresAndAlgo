package com.interview.dynamic.programming;

public class CountMazePathMemoized {

	public static void main(String[] args) {

		int n = 15;

		long startTime = System.currentTimeMillis();
		int count = countMazePath(0, 0, n, n, new int[n + 1][n + 1]);
		System.out.println(count);
		long endTime = System.currentTimeMillis();
		System.out.println("Time Taken : " + (endTime - startTime));

	}

	private static int countMazePath(int srcRow, int srcCol, int destRow, int destCol, int[][] storage) {

		if (srcRow == destRow && srcCol == destCol) {
			return 1;
		}

		if (srcRow > destRow || srcCol > destCol) {
			return 0;
		}

		if (storage[srcRow][srcCol] != 0) {
			return storage[srcRow][srcCol];
		}

		int count = 0;

		int horizontalCount = countMazePath(srcRow, srcCol + 1, destRow, destCol, storage);
		int verticalCount = countMazePath(srcRow + 1, srcCol, destRow, destCol, storage);

		count = horizontalCount + verticalCount;

		storage[srcRow][srcCol] = count;

		return count;

	}
}
