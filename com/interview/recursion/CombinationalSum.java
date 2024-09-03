package com.interview.recursion;

public class CombinationalSum {

	// Given an array of positive integers arr[] and a sum x, find all unique
	// combinations in arr[] where the sum is equal to x. The same repeated number
	// may be chosen from arr[] unlimited number of times. Elements in a combination
	// (a1, a2, …, ak) must be printed in non-descending order. (ie, a1 <= a2 <= …
	// <= ak).
	//The combinations themselves must be sorted in ascending order,i.e., the combination with smallest first element
	//should be printed first. If there is no combination possible the print"Empty"(without quotes).

	
	
	public static void printCombinations(int[] arr,int start, int key, int sum, String path) {
		
		
		if(sum == key) {
			System.out.println(path);
			return;
		}
		
		
		
		for(int i = start ; i < arr.length; i++) {
			
			
			
			sum = sum + arr[i];
			
			if(sum <= key) {
				
				printCombinations(arr, start, key, sum, path + " " + arr[i]);
				
			}
			sum = sum -arr[i];
			start++;
			
		}
	}
	
	public static void main(String[] args) {
		
		int[] arr = {2,4,6,8};
		// here array is sorted , if it is an unsorted array then we should sort the array first.
		
		printCombinations(arr,0, 8, 0, "");
	}
}
