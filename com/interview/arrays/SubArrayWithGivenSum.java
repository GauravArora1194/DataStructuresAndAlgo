package com.interview.arrays;

public class SubArrayWithGivenSum {

public static void main(String[] args) {
		
		int[] arr = {15,2,4,8,9,5,10,23};
		// int[] arr = {15,2,4,8,9};
		
		findArray(arr, 23);
	}
	
	public static void findArray(int[] arr, int sum) {
		
		
		int currentSum = arr[0];
		int start = 0;
		
		
		for(int i = 1; i < arr.length; i++ ) {
			
			
			if(currentSum > sum) {
				currentSum = currentSum - arr[start];
				start ++;
			}
			
			
			if(currentSum == sum) {
				System.out.println("sum found between index : " + start + " and " + (i-1));
				return;
			}else {
			
				currentSum = currentSum + arr[i];
			}
			
		}
		
		if(currentSum == sum) {
			System.out.println("sum found between index : " + start + " and " + (arr.length-1));
		}else {
			
			System.out.println("No subarray found");
		}
		
	}
	
	
	/*public static void findArray2(int[] arr, int sum) {
		int start = 0, end = 0, currSum = 0;

		while (start < arr.length -1) {

			if (currSum<sum) {
				currSum += arr[end];
				end++;
			}

			else if (currSum ==sum) {
				System.out.println("sum found between index : " + start + " and " + (end-1));
				return ;
			}

			else {
				currSum -= arr[start];
				start++;
			}
		}
		System.out.println("No subarray found");
	}*/
	
	
}
