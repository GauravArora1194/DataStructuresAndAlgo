package com.interview.dynamic.programming;

public class LongestIncreasingSubsequenceTabulated {

	
	public static void LIS(int[] arr) {
		
		int[] lengthArr = new int[arr.length];
		
		String[] seqArr = new String[arr.length];
		
		
		
		
		lengthArr[0] = 1;
		seqArr[0] = arr[0] + "";
		
		int overallMax = lengthArr[0];
		String overallPath =seqArr[0];
		
		
		for(int i = 1; i < arr.length; i++) {
			
			seqArr[i] = "";
			
			for(int j = 0 ; j <= i-1; j++) {
				
				if(arr[j]  < arr[i]) {
					
					if(lengthArr[j] > lengthArr[i]) {
						lengthArr[i] = lengthArr[j];
						seqArr[i] = seqArr[j];
					}
				}
			}
			
			lengthArr[i] +=1;
			seqArr[i] = seqArr[i] + " " + arr[i];
			
			if(lengthArr[i] > overallMax) {
				overallMax = lengthArr[i];
				overallPath = seqArr[i];
			}
		}
		
		System.out.println(overallMax);
		System.out.println(overallPath);
		
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {10,22,9,33,21,50,41, 60,80, 1};
		int[] arr1 = {10,5,4,3};
		
		LIS(arr);
		LIS(arr1);
	}
}
