package com.interview.expedia;


// Given an array of n integers. Find the maximum length of the subsequence with difference between adjacent elements as
// either 0 or 1.
public class MaxLengthSubsequenceWithDiff0Or1 {
	
	
	
	public static int maxLengthSubSeq(int[] arr) {
		
		
		int[] lengthArr = new int[arr.length];
		
		lengthArr[0] = 1;
		int max = 1;
		int diff = Integer.MIN_VALUE;
		
		
		for(int i = 1; i < arr.length; i++) {
			
			
			for(int j = 0; j < i; j++) {
				
				diff = Math.abs(arr[i] - arr[j]);
				
				if(diff == 0 || diff == 1 && lengthArr[j] > lengthArr[i]) {
					lengthArr[i] = lengthArr[j];
				}
				
			}
			
			lengthArr[i] += 1;
			
			if(lengthArr[i] > max) {
				max = lengthArr[i];
			}
			
		}
		
		
		return max;
		
	}
	
	
	public static void main(String[] args) {
		
		
		int[] arr = {2,5,6,3,7,6,5,8};
		int[] arr1 = {-2,-1,5,-1,4,0,3};
		
		System.out.println("Max Length of 1st array: " + maxLengthSubSeq(arr));
		System.out.println("Max Length of 2st array: " + maxLengthSubSeq(arr1));
	}

}
