package com.interview.questions;

import java.io.File;

public class PascalTriangle {
	
	
	//we can also use binomial coefficient c(line, i ) = line!/i!*(line-i)!
	//using 2d matrix, complexity n^2 and space n^2
	public static void getPascalTriangle(int n) {
		
		
		int[][] arr = new int[n][n];
		
		
		for(int line = 0 ; line < n ; line++) {
			
			for(int i = 0 ; i <= line ; i++) {
				
				if(i == 0 || i == line) {
					arr[line][i] = 1;
				}else {
					arr[line][i] = arr[line-1][i] + arr[line-1][i-1];
					
				}
				System.out.print(arr[line][i] + " ");
			}
			
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		
		
		getPascalTriangle(7);

	}

}
