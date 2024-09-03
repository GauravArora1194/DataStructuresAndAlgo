package com.interview.arrays;

public class TransposeMatrix {

	// 1 2 3          1 4 7
	// 4 5 6 ->       2 5 8
	// 7 8 9          3 6 9

	// 01 -10 , 02- 20, 12-21

	public static int[][] transpose(int[][] matrix) {

		int rowLength = matrix.length;
		int colLength = matrix[0].length;

		int[][] newMatrix = new int[colLength][rowLength];

		for (int row = 0; row < rowLength; row++) {

			for (int col = 0; col < colLength; col++) {

				newMatrix[col][row] = matrix[row][col];

			}
		}

		return newMatrix;
	}

	private static void transpose1(int[][] arr) {

		for (int row = 0; row < arr.length; row++) {

			for (int col = row; col < arr[row].length; col++) {

				swapCell(arr, row, col);

			}
		}
	}

	private static void swapCell(int[][] arr, int row, int col) {
		int temp = arr[row][col];
		arr[row][col] = arr[col][row];
		arr[col][row] = temp;
	}

	private static void printArray(int[][] newMatrix) {
		for (int row = 0; row < newMatrix.length; row++) {

			for (int col = 0; col < newMatrix[0].length; col++) {

				System.out.print(newMatrix[row][col] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int[][] newMatrix = transpose(matrix);

		printArray(newMatrix);
		
		System.out.println("----------------------------");
		
		System.out.println("Transpose without using new Array");
		System.out.println("----------------------------");
		
		transpose1(matrix);
		
		printArray(matrix);
	}
}
