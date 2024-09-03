package com.interview.dynamic.programming;

public class LongestIncreasingSubsequenceMemoized {

	
	public static void lisEntryPoint(int[] arr) {
		
		int overalMax = 0;
		
		int[] qb = new int[arr.length];
		
		for(int i = 1; i < arr.length; i++) {
			
			int lisEndingAtI = lisEndingAtPoint(arr, i, qb);
			
			if(lisEndingAtI > overalMax) {
				overalMax = lisEndingAtI;
			}
		}
		
		System.out.println(overalMax);
		
	}
	
	public static int lisEndingAtPoint(int[] arr, int point, int[] qb) {
	
		if(point == 0) {
			return 1;
		}
		
		
		if(qb[point] != 0) {
			return qb[point];
		}
		
		int lisEndingAtPoint = 0; 
		
		for(int i = 0 ; i < point; i++) {
			
			if(arr[i] < arr[point]) {
				
				int lenghtOfLisEndingAtI = lisEndingAtPoint(arr, i, qb);
				
				if(lenghtOfLisEndingAtI > lisEndingAtPoint) {
					lisEndingAtPoint = lenghtOfLisEndingAtI;
				}
			}
		}
		
		 lisEndingAtPoint += 1;
		 qb[point] = lisEndingAtPoint;
		 return lisEndingAtPoint;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {10,22,9,33,21,50,41, 60,80, 1};
		
		lisEntryPoint(arr);
	}
}
