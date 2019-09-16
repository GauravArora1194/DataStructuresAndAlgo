package com.interview.dynamic.programming;

public class CountMazePathTabulated {

	public static void main(String[] args) {

		int n = 15;

		long startTime = System.currentTimeMillis();
		int count = countMazePath(n, n);
		System.out.println(count);
		long endTime = System.currentTimeMillis();
		System.out.println("Time Taken : " + (endTime - startTime));

	}

	private static int countMazePath(int destRow, int destCol) {

		int[][] arr = new int[destRow + 1][destCol + 1];

		for (int row = destRow; row >= 0; row--) {

			for (int col = destCol; col >= 0; col--) {

				if (row == destRow && col == destCol) {
					// last cell
					arr[row][col] = 1;
				} else if (row == destRow) {
					// last row except last cell
					arr[row][col] = arr[row][col + 1];
				} else if (col == destCol) {
					// last column except last cell
					arr[row][col] = arr[row + 1][col];
				} else {
					arr[row][col] = arr[row + 1][col] + arr[row][col + 1];
				}
			}
		}

		return arr[0][0];

	}

}
