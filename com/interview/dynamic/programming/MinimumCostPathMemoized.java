package com.interview.dynamic.programming;

public class MinimumCostPathMemoized {

	public static void main(String[] args) {

		int[][] cost = { { 2, 3, 0, 4 }, { 0, 6, 5, 2 }, { 8, 0, 3, 7 }, { 2, 0, 4, 2 } };

		long startTime = System.currentTimeMillis();

		// int minCost = minimumCostPath(0, 0, cost.length - 1, cost[0].length - 1,
		// cost);
		int minCost = minimumCostMemoized(0, 0, cost.length - 1, cost[0].length - 1, cost,
				new int[cost.length][cost[0].length]);
		System.out.println(minCost);
		long endTime = System.currentTimeMillis();
		System.out.println("Time Taken : " + (endTime - startTime));
	}

	private static int minimumCostPath(int srcRow, int srcCol, int destRow, int destCol, int[][] cost) {

		if (srcRow == destRow && srcCol == destCol) {

			return cost[srcRow][srcCol];
		}

		int minCostSrcToDest = 0;

		int minCostHorizontalToDest = Integer.MAX_VALUE;
		int minCostVerticalToDest = Integer.MAX_VALUE;

		if (srcRow < destRow) {

			minCostVerticalToDest = minimumCostPath(srcRow + 1, srcCol, destRow, destCol, cost);
		}

		if (srcCol < destCol) {

			minCostHorizontalToDest = minimumCostPath(srcRow, srcCol + 1, destRow, destCol, cost);
		}

		minCostSrcToDest = cost[srcRow][srcCol] + Math.min(minCostHorizontalToDest, minCostVerticalToDest);

		return minCostSrcToDest;

	}

	private static int minimumCostMemoized(int srcRow, int srcCol, int destRow, int destCol, int[][] cost,
			int[][] storage) {

		if (srcRow == destRow && srcCol == destCol) {

			return cost[srcRow][srcCol];
		}

		if (storage[srcRow][srcCol] != 0) {

			return storage[srcRow][srcCol];
		}

		int minCostSrcToDest = 0;

		int minCostHorizontalToDest = Integer.MAX_VALUE;
		int minCostVerticalToDest = Integer.MAX_VALUE;

		if (srcRow < destRow) {

			minCostVerticalToDest = minimumCostMemoized(srcRow + 1, srcCol, destRow, destCol, cost, storage);
		}

		if (srcCol < destCol) {

			minCostHorizontalToDest = minimumCostMemoized(srcRow, srcCol + 1, destRow, destCol, cost, storage);
		}

		minCostSrcToDest = cost[srcRow][srcCol] + Math.min(minCostHorizontalToDest, minCostVerticalToDest);

		storage[srcRow][srcCol] = minCostSrcToDest;

		return minCostSrcToDest;

	}
}
