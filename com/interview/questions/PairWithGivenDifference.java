package com.interview.questions;

import java.util.Arrays;

public class PairWithGivenDifference {
	
	
	
	public static void getPairWithDiff(int[] arr, int diff) {
		
		if(arr.length < 2) {
			return;
		}
		
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = 1;
		
		while(right < arr.length) {
			
			
			if(arr[right] - arr[left]  <  diff)
				right++;
			else if(arr[right] - arr[left] > diff)
				left++;
			else {
				System.out.println("{" + arr[left] + " , " + arr[right] + "}");
				left++;
				right++;
			}
			
			
		}
		
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {5,2,70,12,90,80};
		
		getPairWithDiff(arr, 78);
		
	}

}
