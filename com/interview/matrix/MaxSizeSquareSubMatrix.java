package com.interview.matrix;

public class MaxSizeSquareSubMatrix {

	// Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
	
	// Make a 2D matrix temp[i][j] , where entry at each cell tells the max length of sub-array till that point.
	
	
	
	public static int findMaxLengthSubMatrix(int[][] matrix) {
		
		
		int rowLength = matrix.length;
		int colLength = matrix[0].length;
		
		int maxLength = 0;
		
		// indexes of start and end point of square sub matrix
		int startRow = -1;
		int startCol = -1;
		int endRow = -1;
		int endCol = -1;
		
		int[][] temp = new int[rowLength][colLength];
		
		
		// copy first row as it is in temp matrix
		for(int col = 0; col < colLength; col++) {
			
			temp[0][col] = matrix[0][col];
		}
		
		// copy first column as it is in temp matrix
		for(int row = 0; row < rowLength; row++) {
					
			temp[row][0] = matrix[row][0];
		}
		
		
		for(int row = 1; row < rowLength; row++) {
			
			for(int col = 1; col < colLength; col++) {
				
				if(matrix[row][col] == 1) {
					temp[row][col] = Math.min(temp[row][col-1], Math.min( temp[row-1][col], temp[row-1][col-1])) + 1;
				}else {
					temp[row][col] = 0;
				}
				
				
				if(temp[row][col] > maxLength) {
					
					maxLength = temp[row][col];
					endRow = row;
					endCol = col;
				}
					
			}
		}
		
		startRow = endRow - (maxLength -1);
		startCol = endCol - (maxLength -1);
		
		System.out.println("start point : (" + startRow + "," + startCol + ")");
		System.out.println("end point : (" + endRow + "," + endCol + ")");
		
		return maxLength;
	}
	
	
	public static void main(String[] args) {
		
		/*int[][] matrix = {
				{0, 1, 1, 0, 1}, 
                {1, 1, 0, 1, 0}, 
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
		};*/
		
		int[][] matrix = {
				{1, 1, 1, 1, 1}, 
                {1, 1, 1, 1, 1}, 
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
		};
		
		System.out.println("Max size sqaure sub matix has length : " + findMaxLengthSubMatrix(matrix));
	}
	
}
