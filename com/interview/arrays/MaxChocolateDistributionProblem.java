package com.interview.arrays;

public class MaxChocolateDistributionProblem {

	// Given n boxes containing some chocolates arranged in a row. There are k
	// number of students. The problem is to distribute maximum number of chocolates
	// equally among k students by selecting a consecutive sequence of boxes from
	// the given lot. Consider the boxes are arranged in a row with numbers from 1
	// to n from left to right. We have to select a group of boxes which are in
	// consecutive order that could provide maximum number of chocolates equally to
	// all the k students. An array arr[] is given representing the row arrangement
	// of the boxes and arr[i] represents number of chocolates in that box at
	// position ‘i’.
	
	
	//Example : 
	
	//Input : arr[] = {2, 7, 6, 1, 4, 5}, k = 3
	//Output : 6
	//The sub-array is {7, 6, 1, 4} with sum 18.
	//Equal distribution of 18 chocolates among 3 students is 6.
	//Note that the selected boxes are in consecutive order with indexes {1, 2, 3, 4}.
	
	
	//Naive Approach (O(n^2))
	
	public static int findMaxChocolate(int[] arr, int k) {
		
		int max = 0;
		int startIndex = 0;
		int endIndex = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			int sum = arr[i];
			
			
			for(int j = i+1; j < arr.length; j++) {
				
				sum = sum + arr[j];
				
				if(sum % k == 0  && sum > max) {
					max = sum;
					startIndex = i;
					endIndex = j;
				}
			}
		}
		
		System.out.println("Start Index : " + startIndex);
		System.out.println("End Index : " + endIndex);
		return max/k;
		
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {2, 7, 6, 1, 4, 9, 5};
		
		int k = 4;
		
		System.out.println("maximum number of chocolates are : " + findMaxChocolate(arr, k));
	}

}
