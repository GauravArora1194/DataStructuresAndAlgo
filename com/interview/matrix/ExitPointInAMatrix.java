package com.interview.matrix;

public class ExitPointInAMatrix {

	public static void main(String[] args) {

		int[][] matrix = {

				{ 0, 0, 1, 0 }, { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 1, 0 } };

		int row = 0;
		int col = 0;

		int direction = 0; // 0 is east, 1 is south, 2 is west, 3 is north

		while (true) {

			direction = (direction + matrix[row][col]) % 4;

			int newRow = row;
			int newCol = col;

			if (direction == 0) { // east

				newCol++;

			} else if (direction == 1) { // south

				newRow++;

			} else if (direction == 2) { // west

				newCol--;

			} else if (direction == 3) { // north

				newRow--;

			}

			if (newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[0].length) {

				System.out.println(row + " " + col);
				break;
			} else {
				row = newRow;
				col = newCol;
			}
		}
	}

}
