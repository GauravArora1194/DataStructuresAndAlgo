package com.interview.arrays.advanced;


// Given an array A of integers, find the maximum of j - i 
// subjected to the constraint of A[i] <= A[j].

public class MaximumIndex {

	
	public static int maxIndex(int[] arr) {
		
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				
				if(arr[j] >= arr[i] && j - i > max) {
					max = j - i;
				}
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {3, 5, 4, 2};
		
		int[] arr1 = {3, 5, 4, 2, 1, 7};
		
		System.out.println("Max Index Length is : " + maxIndex(arr));
		
		System.out.println("Max Index Length is : " + maxIndex(arr1)); 
	}
}
