package com.interview.arrays.advanced;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingElement {

	// Find the first repeating element in an array of integers, i.e., an element
	// that occurs more than once and whose index of first occurrence is smallest.
	
	public static int firstRepeatElement(int[] arr) {
		
		
		int min = -1;
		
		Set<Integer> set = new HashSet<>();
		
		for(int i = arr.length - 1; i >= 0; i--) {
			
			if(set.contains(arr[i]))
				min = i;
			
			else
				set.add(arr[i]);
			
		}
		
		if(min == -1)
			return -1;
		else
			return arr[min];
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1, 5, 3, 4, 3, 5, 6};
		
		System.out.println("First repeating element : " + firstRepeatElement(arr));
	}
}
