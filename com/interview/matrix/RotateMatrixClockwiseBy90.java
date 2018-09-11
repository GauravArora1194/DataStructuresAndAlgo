package com.interview.matrix;


// Step 1 - Take the transpose of the matrix
// Step 2 - Reverse the columns.

public class RotateMatrixClockwiseBy90 {
	
	
	public static void transpose(int[][] arr) {
		
		for(int row = 0; row < arr.length; row++) {
			
			for(int col = row; col < arr[0].length; col++) {
				
				int temp = arr[row][col];
				arr[row][col] = arr[col][row];
				arr[col][row] = temp;
				
			}
		}
		
	}
	
	
	public static void reverseColumns(int[][] arr) {
		
		
		int minCol = 0;
		int maxCol = arr[0].length -1;
		
		
		while(minCol < maxCol) {
			
			for(int row = 0; row < arr.length; row++) {
				
				// swap elements
				int temp = arr[row][minCol];
				arr[row][minCol] = arr[row][maxCol];
				arr[row][maxCol] = temp;
			}
			
			minCol++;
			maxCol--;
		}
	}
	
	
	public static void rotate(int[][] arr) {
		
		transpose(arr);
		reverseColumns(arr);
		
	}
	
	
	public static void displayMatrix(int[][] arr) {

		for (int row = 0; row < arr.length; row++) {

			for (int col = 0; col < arr[0].length; col++) {

				System.out.print(arr[row][col] + " ");
				
			}
			
			System.out.println();
		}
	}

	
	public static void main(String[] args) {
		

		int[][] matrix = {
				
				{11, 12, 13, 14},
				{21, 22, 23, 24},
				{31, 32, 33, 34},
				{41, 42, 43, 44}
				
		};
		
		
		rotate(matrix);
		
		displayMatrix(matrix);
		
		
	}
}
