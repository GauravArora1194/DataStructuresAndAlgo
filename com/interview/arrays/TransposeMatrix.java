package com.interview.arrays;

public class TransposeMatrix {

	//1 2 3       1 4 7
	//4 5 6   ->  2 5 8
	//7 8 9       3 6 9
	
	//01 -10 , 02- 20, 12-21
	
	public static void printTranspose(int[][] matrix) {
		
		int rowLength = matrix.length;
		int colLength = matrix[0].length;
		
		int[][] newMatrix = new int[colLength][rowLength];
		
		
		for(int row = 0 ; row < rowLength; row++) {
			
			for(int col = 0 ; col < colLength; col++) {
				
				newMatrix[col][row] = matrix[row][col];
				
			}
		}
		
		
		for(int row = 0; row < newMatrix.length; row++) {
			
			for(int col = 0; col < newMatrix[0].length; col++) {
				
				System.out.print(newMatrix[row][col] + " ");
			}
			System.out.println();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
				
		};
		
		printTranspose(matrix);
	}
}
