package com.interview.arrays;

import java.util.Arrays;

public class PythagoreanTriplet {

	// find if there exists any triplet that satisfies a^2 + b^ = C^2 (i.e pythagoras theorem) 
	
	public static void findTriplet(int[] arr) {
		
		
		Arrays.sort(arr);
		
		boolean flag = false;
		int count = 0;
		int j = 0;
		
		for(int i = 0; i < arr.length - 2 && j < arr.length ; ) {
			
			if(!flag) {
				
				j = i+2;
			}
			
			
			int temp = arr[i] * arr[i] + arr[i+1] * arr[i+1];
			
			if(temp == arr[j] * arr[j]) {
				count++;
				System.out.println("Triplet : { " + arr[i] +", " + arr[i+1] + ", " + arr[j] + " }");
				flag = false;
				i++;
			}else if(temp < arr[j] * arr[j] ) {
				i++;
				flag = false;
			}else {
				flag = true;
				j++;
			}
		}
		
		if(count == 0) {
			System.out.println("No triplet exist!");
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {3, 1, 4, 6, 5, 10, 8};
		// 1 3 4 5 6
		
		int[] arr1 = {10, 4, 6, 12, 5};
		//4 5 6 10 12 
		
		findTriplet(arr);
		
		findTriplet(arr1);
		
	}
}
