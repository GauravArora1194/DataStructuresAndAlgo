package com.interview.recursion;

public class AllPossiblePathsInAMatrix {

	
	// Prints all possible paths from top left to bottom right of a M X N matrix
	// constraint - from each cell you can move either right or down
	
	static int count = 0 ;
	
	public static void printAllPaths(int[][] matrix, int row , int col, String path ) {
		
		
		if(row == matrix.length-1 && col == matrix[0].length -1) {
			count++;
			System.out.println(count + ". " + path + " " + matrix[row][col]);
			
			return;
		}
		
		
		if(row+1 <= matrix.length-1) {
			printAllPaths(matrix, row+1, col, path + " " + matrix[row][col]);
		}
		
		
		if(col+1 <= matrix[0].length-1) {
			printAllPaths(matrix, row, col+1, path + " " + matrix[row][col]);
		}
		
	}
	
	
	public static void main(String[] args) {
		
		
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		int[][] matrix1 = {
				{1,2},
				{3,4}
		};
		
		printAllPaths(matrix, 0, 0, "");
		
		printAllPaths(matrix1, 0, 0, "");
		
	}
	
}
