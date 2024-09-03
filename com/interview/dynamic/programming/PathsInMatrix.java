package com.interview.dynamic.programming;

public class PathsInMatrix {

	// counts the number of paths from start (0,0) to end (m,n) in a matrix;
	// from each cell we can move either right or down
	
	public static int countPaths(int[][] matrix) {
		
		int rowSize = matrix.length;
		int colSize = matrix[0].length;
		
		int[][] countArr = new int[rowSize][colSize];
		
		for(int i = 0 ; i < rowSize; i++)
			countArr[i][0] = 1;
		
		for(int j = 0; j < colSize; j++)
			countArr[0][j] = 1;
		
		for(int row = 1; row < rowSize; row++) {
			
			for(int col = 1; col < colSize; col++) {
				
				countArr[row][col] = countArr[row-1][col] + countArr[row][col-1];
			}
		}
		
		return countArr[rowSize-1][colSize-1];
		
	}
	
	
	public static void main(String[] args) {
		
		
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		System.out.println("Total Paths : " + countPaths(matrix));
	}
}
