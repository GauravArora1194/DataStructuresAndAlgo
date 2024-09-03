package com.interview.questions;

public class EquilibriumPointInAnArray {

	
	public static int getPoint(int[] arr) {
		
		int sum = 0;
		int leftSum = 0;
		
		
		for(int i : arr) {
			sum = sum + i;
		}
		
		int rightSum = sum;
		for(int i = 0; i < arr.length; i++) {
			
			rightSum = rightSum - arr[i];
			
			if(rightSum == leftSum) {
				return i;
			}
			
			leftSum = leftSum + arr[i];
			
		}
		
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		//int[] arr = {1,4,2,5};
		int[] arr = {2,3,4,1,4,5};
		
		System.out.println(arr[getPoint(arr)]);
		
	}
}
