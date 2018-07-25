package com.interview.matrix;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueRowsInAMatrix {

	// Given a binary matrix, print all unique rows of the given matrix.

	// The approach used is to convert each row into a string and make a hash-set
	// containing only unique rows
	
	
	public static void printUniqueRows(int[][] matrix) {
		
		int rowLength = matrix.length;
		int colLength = matrix[0].length;
		
		String temp = "";
		
		Set<String> rowSet = new HashSet<>();
		
		for(int row = 0; row < rowLength; row++) {
			
			for(int col = 0; col < colLength; col++) {
				
				temp = temp + matrix[row][col];
			}
			
			if(!rowSet.contains(temp)) {
				
				rowSet.add(temp);
				System.out.println(temp);
			}
			
			temp = "";
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int[][] matrix = {
				{0, 1, 0, 0, 1},
		        {1, 0, 1, 1, 0},
		        {0, 1, 0, 0, 1},
		        {1, 1, 1, 0, 0}
		};
		
		printUniqueRows(matrix);
	}

}
