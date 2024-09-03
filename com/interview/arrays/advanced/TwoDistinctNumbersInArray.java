package com.interview.arrays.advanced;

import java.util.HashSet;
import java.util.Set;

// Given an array A containing 2*N+2 positive numbers, 
// out of which 2*N numbers exist in pairs whereas the other two number occur exactly once and are distinct.
// You need to find the other two numbers and print them in ascending order.

public class TwoDistinctNumbersInArray {

	public static int[] findAndPrintDistinctNumbers(int[] arr) {
		
		Set<Integer> set = new HashSet<>();
		int[] result = new int[2]; 
		int j = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			if(set.contains(arr[i])) {
				set.remove(arr[i]);
			}else {
				set.add(arr[i]);
			}
		}
		
		for(Integer element : set) {
			
			result[j] = element;
			j++;
		}
		
		if(result[0] > result[1]) {
			//swap
			int temp = result[0];
			result[0] = result[1];
			result[1] = temp;
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 4, 2, 1, 3};
		
		int[] result = findAndPrintDistinctNumbers(arr);
		
		for(int i : result) {
			System.out.println(i);
		}
	}
}
