package com.interview.dynamic.programming;

public class MinimumCostPathTabulated {

	public static void main(String[] args) {

		int[][] cost = { { 2, 3, 0, 4 }, { 0, 6, 5, 2 }, { 8, 0, 3, 7 }, { 2, 0, 4, 2 } };

		long startTime = System.currentTimeMillis();

		int minCost = minCostPath(cost);
		System.out.println(minCost);
		long endTime = System.currentTimeMillis();
		System.out.println("Time Taken : " + (endTime - startTime));
	}

	private static int minCostPath(int[][] cost) {

		int destRow = cost.length - 1;
		int destCol = cost[0].length - 1;

		int[][] minCostArr = new int[destRow + 1][destCol + 1];

		for (int row = destRow; row >= 0; row--) {

			for (int col = destCol; col >= 0; col--) {

				if (row == destRow && col == destCol) {
					// last cell
					minCostArr[row][col] = cost[row][col];
				} else if (row == destRow) {
					// last row except last cell
					minCostArr[row][col] = cost[row][col] + minCostArr[row][col + 1];
				} else if (col == destCol) {
					// last column except last cell
					minCostArr[row][col] = cost[row][col] + minCostArr[row + 1][col];
				} else {
					minCostArr[row][col] = cost[row][col]
							+ Math.min(minCostArr[row + 1][col], minCostArr[row][col + 1]);
				}
			}
		}

		return minCostArr[0][0];

	}
}
