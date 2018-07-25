package com.interview.matrix;

public class SearchElementInSortedMatrix {

	// search element in a nXn matrix that is sorted both row wise and column wise.
	
	public static void findElement(int[][] matrix, int key) {
		
		int n = matrix.length - 1;
		int i = 0;
		int j = n;
		
		while(i < n && j >= 0 ) {
			
			if(matrix[i][j] == key) {
				System.out.println("Element found at index : (" + i + "," + j +")");
				break;
			}else if(matrix[i][j] > key) {
				j--;
			}else {
				i++; // matrix[i][j] < key
			}
			
		}
		
		if(i == n || j < 0) {
			System.out.println("Element not found!");
		}
	}
	
	
	
	public static void main(String[] args) {
		
		int[][] matrix = {
				{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
             };
		
		findElement(matrix, 29);
		findElement(matrix, 60);
	}
}
