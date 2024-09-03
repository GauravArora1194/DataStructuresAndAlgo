package com.interview.arrays.advanced;

import java.util.HashSet;
import java.util.Set;

public class PaytmQuestion {

	
	
	public static int getMinSum(int[] arr) {
		
		int sum = 0;
		int lastElement = 0;
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; i < arr.length; i++) {
			
			if(!set.contains(arr[i])) {
				set.add(arr[i]);
				lastElement = arr[i];
			}else {
				arr[i] = lastElement + 1;
				lastElement = arr[i];
			}
			
			sum = sum + arr[i];
		}
		
		
		return sum;
	}
	
	
	public static void main(String[] args) {
		
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {1,4,5,4,5};
		int[] arr3 = {1, 2, 5, 7, 8, 8, 7};
		
		System.out.println("min sum :" +getMinSum(arr1));
		System.out.println("min sum :" +getMinSum(arr2));
		System.out.println("min sum :" +getMinSum(arr3));
		
		
	}
}
