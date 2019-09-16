package com.interview.dynamic.programming;

public class GoldMineTabulated {

	public static void main(String[] args) {

		int[][] mine = { { 2, 6, 0, 5 }, { 0, 7, 5, 2 }, { 3, 0, 3, 7 }, { 8, 0, 2, 3 } };

		minePathWithMaxProfit(mine);

	}

	private static void minePathWithMaxProfit(int[][] mine) {

		int[][] storage = new int[mine.length][mine[0].length];

		// String[][] path = new String[mine.length][mine[0].length];

		int overallMax = 0;
		int overallRow = -1;
		int overallCol = -1;

		for (int col = mine[0].length - 1; col >= 0; col--) {

			for (int row = 0; row < mine.length; row++) {

				if (col == mine[0].length - 1) {
					// last column
					storage[row][col] = mine[row][col];
				} else if (row == 0) {
					// first row
					storage[row][col] = mine[row][col] + Math.max(storage[row][col + 1], storage[row + 1][col + 1]);
				} else if (row == mine.length - 1) {
					// last row
					storage[row][col] = mine[row][col] + Math.max(storage[row][col + 1], storage[row - 1][col + 1]);
				} else {

					storage[row][col] = mine[row][col] + Math.max(storage[row][col + 1],
							Math.max(storage[row + 1][col + 1], storage[row - 1][col + 1]));
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
