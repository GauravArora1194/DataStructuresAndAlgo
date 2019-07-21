package com.interview.matrix;

public class RotateMatrixby90 {

	// It can be solved using 2 steps -
	// 1. find the transpose of the matrix
	// 2. reverse column/rows of the transpose.

	public static int[][] rotatematrix(int[][] matrix) {

		// first find the transpose of matrix
		transpose(matrix);

		// After the transpose we reverse the array
		reverse(matrix);

		return matrix;

	}

	private static void reverse(int[][] matrix) {

		int left = 0;
		int right = matrix[0].length - 1;

		while (left < right) {

			for (int row = 0; row < matrix.length; row++) {

				swap(matrix, left, right, row);
			}

			left++;
			right--;
		}
	}

	private static void swap(int[][] matrix, int left, int right, int row) {
		
		int temp = matrix[row][left];
		matrix[row][left] = matrix[row][right];
		matrix[row][right] = temp;
	}

	private static void transpose(int[][] matrix) {

		int rowLength = matrix.length;

		for (int row = 0; row < rowLength; row++) {

			for (int col = row; col < matrix[row].length; col++) {

				swap(matrix, row, col);

			}
		}
	}

	private static void swap(int[][] matrix, int row, int col) {

		int temp = matrix[row][col];
		matrix[row][col] = matrix[col][row];
		matrix[col][row] = temp;
	}

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int[][] transpose = rotatematrix(matrix);

		for (int i = 0; i < transpose.length; i++) {

			for (int j = 0; j < transpose[0].length; j++) {

				System.out.print(transpose[i][j] + " ");

			}

			System.out.println();
		}
	}
}
