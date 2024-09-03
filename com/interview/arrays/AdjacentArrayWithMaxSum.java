package com.interview.arrays;


public class AdjacentArrayWithMaxSum {

	
	// Given an array , find the Max sum that can be formed from sub-array such that no two elements are adjacent.
	
	// expected time complexity - O(n) and space complexity - O(1)
	
	
	public static long findMaxSum(int[] arr) {
		
		long inclusive = arr[0];
		long exclusive = 0;
		
		
		for(int i = 1; i < arr.length; i++) {
			
			long temp = inclusive;
			inclusive = Math.max(inclusive, exclusive + arr[i]);
			exclusive = temp;
		}
		
		return Math.max(inclusive, exclusive);
		//return inclusive; (this is also true)
	}
	
	
	public static void main(String[] args) {
		
		
		int[] arr = {5, 5, 10, 100, 10, 5};
		int[] arr1 = {1,2,3};
		int[] arr2 = {1,20,3};
		
		System.out.println("Max Sum : " + findMaxSum(arr));
		
		System.out.println("Max Sum : " + findMaxSum(arr1));
		
		System.out.println("Max Sum : " + findMaxSum(arr2));
		
	}
}

