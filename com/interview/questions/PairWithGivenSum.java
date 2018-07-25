package com.interview.questions;

import java.util.HashSet;

//Using hashing
public class PairWithGivenSum {


	public static void findPair(int[] arr, int sum) {
		
		if(arr.length < 2) {
			return;
		}
		
		HashSet<Integer> set = new HashSet<>(arr.length);
		
		for(int n : arr) {
			
			int target = sum - n;
			
			if(!set.contains(target)) {
				set.add(n);
			}else {
				System.out.println("{" + n +" , " + target + " }");
			}
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		
		int[] arr = {0, 14, 0, 4, 7, 8, 3, 5, 7};
		
		findPair(arr, 11);
		
	}
}
