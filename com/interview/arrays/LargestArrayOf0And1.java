package com.interview.arrays;

public class LargestArrayOf0And1 {

	// Given an array of 0's and 1's
	// finds the largest sub-array of equal number of 0's and 1's
	
	// 1st approach : This approach only finds the length of sub-array
	public static int getMaxLengthSubarray(int[] arr) {
		
		int count0 = 0;
		int count1 = 0;
		
		int maxLength = 0;
		
		for(int i = 0 ; i < arr.length; i++) {
			
			if(arr[i] == 0)
				count0++;
			else
				count1++;
		}
		
		
		//maxLength = Math.min(count0, count1);
		maxLength = count0 > count1 ? count1 : count0;
		
		return maxLength * 2;
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {1, 0, 1, 1, 1, 0, 0};
		
		int[] arr1 = {1,1,1,1};
		
		System.out.println("Length of Max Sub-array : " + getMaxLengthSubarray(arr));
		
		System.out.println("Length of Max Sub-array : " + getMaxLengthSubarray(arr1));
	}
}
