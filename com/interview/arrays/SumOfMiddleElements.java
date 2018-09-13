package com.interview.arrays;

// Given 2 sorted arrays A and B of size N each. 
// Print sum of middle elements of the array obtained after merging the given arrays.

public class SumOfMiddleElements {
	
	// without using extra space.
	public static int sumOfMidElements(int[] arr1, int[] arr2) {
		
		
		int i = 0;
		int j = 0;
		int length = arr1.length + arr2.length;
		int mid1 = -1;
		int mid2 = -1;
		int lastElement = -1;
		int count = -1;
		
		
		while(i < arr1.length && j < arr2.length) {
			
			
			if(arr1[i] < arr2[j]) {
				lastElement = arr1[i];
				i++;
				
			}else {
				lastElement = arr2[j];
				j++;
			}
			
			count++;
			
			if(count == length / 2 - 1) {
				mid1 = lastElement;
			}
			
			if(count == length / 2) {
				mid2 = lastElement;
				break;
			}
		}
		
		if (i < arr1.length && count != length / 2) {
			
			mid2 = arr1[i];
			
		}
		
		if (j < arr2.length && count != length / 2) {
			
			mid2 = arr2[j];
			
		}
		
		return  mid1 + mid2;
	}
	
	public static void main(String[] args) {
		
		int[] arr1 = {1, 2, 4, 6, 10};
		int[] arr2 = {4, 5, 6, 9, 12};
		
		int sum = sumOfMidElements(arr1, arr2);
		
		System.out.println(sum);
		
		int[] arr3 = {1, 2, 3, 4, 5};
		int[] arr4 = {10, 20, 30, 40, 50};
		
		int sum1 = sumOfMidElements(arr3, arr4);
		
		System.out.println(sum1);
	}

}
