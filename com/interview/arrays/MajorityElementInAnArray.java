package com.interview.arrays;

import java.util.HashMap;
import java.util.Map;

//  A majority element in an array A[] of size n is an element 
// that appears more than n/2 times (and hence there is at most one such element).

public class MajorityElementInAnArray {

	public static int getMajorityElement(int[] arr) {

		Map<Integer, Integer> map = new HashMap<>();

		int majorityElement = -1;

		for (int element : arr) {

			if (map.containsKey(element)) {

				int count = map.get(element) + 1;
				map.put(element, count);

				if (count > arr.length / 2) {
					majorityElement = element;
				}

			} else {
				map.put(element, 1);
			}
		}

		return majorityElement;
	}
	
	public static int getMajorityElementSpaceOptimized(int[] arr) {
		// potential candidate
		int value = arr[0];
		int count = 1;
		
		for(int i = 1; i < arr.length; i++) {
			
			if(value == arr[i]) {
				count++;
			} else {
				count--;
			}
			
			if(count == 0) {
				value = arr[i];
				count = 1;
			}
		}
		
		int valCount = 0;
		
		for(int  i = 0; i < arr.length; i++) {
			
			if(arr[i] == value) {
				valCount++;
			}
		}
		
		if(valCount > arr.length / 2) {
			return value;
		} else {
			return -1;
		}
		
	}

	public static void main(String[] args) {

		int[] arr = { 3, 1, 3, 3, 2 };

		int majorityElement = getMajorityElementSpaceOptimized(arr);

		if (majorityElement == -1) {

			System.out.println("No Majority Element Exist!");

		} else {
			System.out.println("Majority Element is : " + majorityElement);
		}

		int[] arr1 = { 1, 2, 3 };

		int majorityElement1 = getMajorityElementSpaceOptimized(arr1);

		if (majorityElement1 == -1) {

			System.out.println("No Majority Element Exist!");

		} else {
			System.out.println("Majority Element is : " + majorityElement1);
		}
	}
}
