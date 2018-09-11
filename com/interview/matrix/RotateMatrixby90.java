package com.interview.matrix;

public class RotateMatrixby90 {
	
	
	// It can be solved using 2 steps - 
	// 1. find the transpose of the matrix
	// 2. reverse column/rows of the transpose.

	
	public static int[][] rotatematrix(int[][] matrix){
		
		int rowLength = matrix.length;
		int colLength = matrix[0].length;
		
		// first find the transpose of matrix
		for(int i = 0; i < rowLength; i++) {
			
			for(int j = i; j < colLength; j++) {
				
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
				
			}
		}
		
		
		// After transpose we swap elements of
	    // column one by one for finding left
	    // rotation of matrix by 90 degree
		for (int i = 0; i < matrix[0].length; i++)
            for (int j = 0,  k = matrix[0].length - 1;
                             j < k; j++, k--)
            {  
                int temp = matrix[j][i];
                matrix[j][i] = matrix[k][i];
                matrix[k][i] = temp;
            }
		
		
		// We can also do this-
		
		/*for(int i = 0, k = rowLength -1; i < k ; i++, k-- ) {
			
			for(int j = 0; j < colLength ;j++) {
				
				int temp = matrix[i][j];
				matrix[i][j] = matrix[k][j];
				matrix[k][j] = temp;
			}
		}*/
		
		return matrix;
		
	}
	
	
	public static void main(String[] args) {
		
		int[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		int[][] transpose = rotatematrix(matrix);
		
		
		for(int i = 0; i < transpose.length; i++) {
			
			for(int j = 0; j < transpose[0].length; j++) {
				

				System.out.print(transpose[i][j] + " ");
				
			}
			
			System.out.println();
		}
	}
}
