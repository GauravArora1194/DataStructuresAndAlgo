package com.interview.arrays;

import java.util.HashMap;
import java.util.Map;

//  A majority element in an array A[] of size n is an element 
// that appears more than n/2 times (and hence there is at most one such element).

public class MajorityElementInAnArray {

	
	public static int getMajorityElement(int[] arr) {
		
		
		Map<Integer, Integer> map = new HashMap<>();
		
		int majorityElement = -1;
		
		for(int element : arr) {
		
			if(map.containsKey(element)) {
				
				int count  = map.get(element) + 1;
				map.put(element,count );
				
				if(count > arr.length /2) {
					majorityElement = element;
				}
				
			}
			else {
				map.put(element, 1);
			}
		}
		
		return majorityElement;
	}
	
	
	public static void main(String[] args) {
		
		
		int[] arr = {3, 1, 3, 3, 2};
		
		int majorityElement = getMajorityElement(arr);
		
		if(majorityElement == -1) {
			
			System.out.println("No Majority Element Exist!");
			
		}else {
			System.out.println("Majority Element is : " + majorityElement);
		}
		
		
		int[] arr1 = {1, 2, 3};
		
		int majorityElement1 = getMajorityElement(arr1);
		
		if(majorityElement1 == -1) {
			
			System.out.println("No Majority Element Exist!");
			
		}else {
			System.out.println("Majority Element is : " + majorityElement1);
		}
	}
}
