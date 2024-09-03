package com.interview.matrix;

public class BooleanMatrixQues {

	// Given a boolean matrix mat[M][N] of size M X N, modify it such that if a
	// matrix cell mat[i][j] is 1 (or true) then make all the cells of ith row and
	// jth column as 1.
	
	
	public static int[][] modifyMatrix(int[][] matrix){
		
		
		int rowLength = matrix.length;
		int colLength = matrix[0].length;
		
		// flag to check if the first row contains at least one 1.
		boolean rowSetFlag = false; 
		
		// flag to check if the first column contains at least one 1.
		boolean colSetFlag = false;
		
		for(int col = 0; col < colLength; col++) {
			
			if(matrix[0][col] == 1) {
				rowSetFlag = true;
				break;
			}
		}
		
		
		for(int row = 0; row < rowLength; row++) {
			
			if(matrix[row][0] == 1) {
				colSetFlag = true;
				break;
			}
		}	
		
		
		for(int row = 1; row < rowLength; row++) {
			
			for(int col = 1; col < colLength; col++) {
				
				if(matrix[row][col] == 1) {
					
					matrix[row][0] = 1;
					matrix[0][col] = 1;
				}
				
			}
		}
		
		
		for(int row = 1; row < rowLength; row++) {
			
			for(int col = 1; col < colLength; col++) {
				
				if(matrix[row][0] == 1 || matrix[0][col] == 1) {
					
					matrix[row][col] = 1;
				}
				
			}
		}	
		
		
		if(rowSetFlag) {
			for(int col = 0; col < colLength; col++) {
				
				matrix[0][col] = 1;
			}
		}
		
		if(colSetFlag) {
			for(int row = 0; row < rowLength; row++) {
				
				matrix[row][0] = 1;
			}
		}
		
		
		
		return matrix;
		
	}
	
	
	
	public static void main(String[] args) {
		
		// test case 1
		System.out.println("first test case : ");
		int[][] matrix = {
				{1,0},
				{0,0}
		};
		
		int[][] result = modifyMatrix(matrix);
		
		for(int row = 0; row < matrix.length; row++) {
			
			for(int col = 0; col < matrix[0].length; col++) {
				
				System.out.print(result[row][col] + " ");
				
			}
			System.out.println();
		}	
		
		
		
		System.out.println("Second test case : ");
		// test case 2
		int[][] matrix1 = {
				{1,0,0,1},
				{0,0,1,0},
				{0,0,0,0}
			};
				
		int[][] result1 = modifyMatrix(matrix1);
				
		for(int row = 0; row < matrix1.length; row++) {
					
			for(int col = 0; col < matrix1[0].length; col++) {
						
					System.out.print(result1[row][col] + " ");
						
				}
					System.out.println();
			}	
		
	}

}
