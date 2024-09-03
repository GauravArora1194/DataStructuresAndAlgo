package com.interview.hashing;

import java.util.HashMap;
import java.util.Map;

public class DistinctElementInEveryWindowOfSizeK {

	// given an array, counts the number of distinct elements in every window of size K
	
	
	public static void countDistinctElements(int[] arr, int k) {
		
		
		Map<Integer,Integer> map = new HashMap<>();
		
		int start = 0;
		
		for(int i = 0; i < k; i++) {
			
			if(!map.containsKey(arr[i]))
				map.put(arr[i], 1);
			else
				map.put(arr[i], map.get(arr[i]) + 1);
		}
		
		System.out.println(map.size());
		
		for(int i = k ; i < arr.length; i++) {
			
			if(map.get(arr[start]) > 1)
				map.put(arr[start], map.get(arr[start]) - 1);
			else
				map.remove(arr[start]);
			
			start++;
			
			if(!map.containsKey(arr[i]))
				map.put(arr[i], 1);
			else
				map.put(arr[i], map.get(arr[i]) + 1);
			
			System.out.println(map.size());
				
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 1, 3, 4, 2, 3};
		
		countDistinctElements(arr, 4);
	}
}
