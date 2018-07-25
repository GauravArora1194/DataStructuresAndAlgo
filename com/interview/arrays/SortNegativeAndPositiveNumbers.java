package com.interview.arrays;

public class SortNegativeAndPositiveNumbers {

	// sort negative and positive numbers such that negative numbers appears before
	// positive and also maintains the order.
	
	//eg. [1,7,-5,9,-12,15] -> [-5,-12,1,7,9,15]
	
	// expected time complexity O(n) and space complexity O(1)
	
	
	//with O(n) space
	public static void sortAndMaintainOrder(int[] arr) {
		
		int[] temp = new int[arr.length];
		
		int start = 0;
		int j = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			if(arr[i] > 0) {
				temp[start] = arr[i];
				start++;
			}else {
				arr[j] = arr[i];
				j++;
			}
		}
		
		
		for(int i = 0 ; i < start; i++) {
			
			arr[j] = temp[i];
			j++;
		}
		
		System.out.println("Modified array is : ");
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1,7,-5,9,-12,15};
		//int[] arr = {-1,-2,-3,-5,-4};
		
		sortAndMaintainOrder(arr);
	}
}
 