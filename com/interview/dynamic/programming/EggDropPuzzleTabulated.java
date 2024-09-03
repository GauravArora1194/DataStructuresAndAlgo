package com.interview.dynamic.programming;

// Given e eggs and f floors building , 
// find the minimum floor from which the eggs break after dropping.

public class EggDropPuzzleTabulated {

	public static int getMinFloor(int eggs, int floor) {

		int[][] matrix = new int[eggs + 1][floor + 1];

		for (int e = 1; e <= eggs; e++) {

			for (int f = 1; f <= floor; f++) {

				if (f == 1) {
					matrix[e][f] = 1;

				} else if (e == 1) {
					matrix[e][f] = f;

				} else {

					int min = Integer.MAX_VALUE;

					for (int k = 1; k <= f; k++) {

						int eggBreaks = matrix[e - 1][k - 1];
						int eggNotBreaks = matrix[e][f - k];

						if (Math.max(eggBreaks, eggNotBreaks) < min) {
							min = Math.max(eggBreaks, eggNotBreaks);
						}
					}

					matrix[e][f] = min + 1;
				}

			}
		}

		return matrix[eggs][floor];

	}

	public static void main(String[] args) {
		
		
		int eggs = 2;
		int floors = 100;
		
		int minFloorCount = getMinFloor(eggs, floors);
		
		System.out.println("Minimum number of floors required : " + minFloorCount);
		
	}

}
