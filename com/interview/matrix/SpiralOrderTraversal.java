package com.interview.matrix;


// Given a 2D matrix, print the matrix in spiral form
public class SpiralOrderTraversal {
	
	
	public static void main(String[] args) {
		
		
		int[][] matrix = {
				
				{11, 12, 13, 14},
				{21, 22, 23, 24},
				{31, 32, 33, 34},
				{41, 42, 43, 44}
				
		};
		
				//     top wall
				//	  _ _ _ _ _
				//   |		   |
// left wall         |		   |  right wall
				//   |_ _ _ _ _|
		
				//     bottom wall
		
		
		int rowMin = 0;
		int colMin = 0;
		int rowMax = matrix.length-1;
		int colMax = matrix[0].length -1;
		
		int counter = 1;
		int totalElement = matrix.length * matrix[0].length;
		
		
		while(counter <= totalElement) {
			
			// print left wall
			for(int row = rowMin; row <= rowMax && counter <= totalElement; row++) {
				System.out.println(matrix[row][colMin] + " ");
				counter++;
			}
			
			colMin++;
			
			// print bottom wall
			for(int col = colMin; col <= colMax && counter <= totalElement; col++) {
				System.out.println(matrix[rowMax][col] + " ");
				counter++;
			}
			
			rowMax--;
			
			// print right wall
			for(int row = rowMax; row >= rowMin && counter <= totalElement; row--) {
				System.out.println(matrix[row][colMax] + " ");
				counter++;
			}
			
			colMax--;
			
			// print top wall
			for(int col = colMax; col >= colMin && counter <= totalElement; col--) {
				System.out.println(matrix[rowMin][col] + " ");
				counter++;
			}
			
			rowMin++;
		}
		
	}

}
