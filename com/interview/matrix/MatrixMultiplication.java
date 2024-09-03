package com.interview.matrix;

public class MatrixMultiplication {

	public static int[][] multiply(int[][] first, int[][] second) {

		int row = first.length;
		int col = second[0].length;

		int[][] result = new int[row][col];

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {

				for (int k = 0; k < second.length; k++) {
					result[i][j] = result[i][j] + first[i][k] * second[k][j];
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {

		int[][] first = { { 10, 0, 0 }, { 0, 5, 1 } };

		int[][] second = { { 0, 5, 10, 0 }, { 20, 0, 1, 2 }, { 1, 1, 1, 5 } };

		int[][] result = multiply(first, second);

		for (int row = 0; row < result.length; row++) {

			for (int col = 0; col < result[0].length; col++) {

				System.out.print(result[row][col] + " ");
			}

			System.out.println();

		}

	}

}
