package com.interview.arrays;

public class LeadersInArray {

	
	public static void main(String[] args) {
		
		
		int[] arr = {16,17,4,3,5,2};
		
		int max = arr[arr.length - 1];
		
		System.out.println("Leaders in array are : ");
		System.out.println(max);
		
		for(int i = arr.length -2; i >=0; i--) {
			if(arr[i] > max) {
				max = arr[i];
				System.out.println(max);
			}
		}
		
	}
}
