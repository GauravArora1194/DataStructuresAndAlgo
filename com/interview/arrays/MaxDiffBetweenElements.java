package com.interview.arrays;

public class MaxDiffBetweenElements {

	
	//finds the maximum difference between two elements such that larger element appears after the smaller element
	
	public static int getMaxDiff(int[] arr) {
		
		int max_diff = arr[1] - arr[0];
		int min_element = arr[0];
		
		for(int i = 1; i < arr.length; i++ ) {
			
			if(arr[i] - min_element > max_diff) {
				max_diff = arr[i] - min_element;
			}
			
			if(arr[i] < min_element) {
				min_element = arr[i];
			}
		}
		
		return max_diff;
		
	}
	
	public static void main(String[] args) {
		
		
		int[] arr = {2,3,10,6,4,8,1};
		int[] arr1 = {7,9,5,6,3,2};
		
		System.out.println(getMaxDiff(arr));
		System.out.println(getMaxDiff(arr1));
	}
}

 