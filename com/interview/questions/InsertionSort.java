package com.interview.questions;

public class InsertionSort {
	
	public static int[] sort(int[] arr) {
		
		int key,j;
		for(int i = 1 ; i < arr.length ; i++) {
			
			key  = arr[i];
			for( j = i-1; j>=0; j--) {
				
				if(key < arr[j]) {
					arr[j+1] = arr[j];
				}else {
					break;
				}
			}
			
				arr[j+1] = key;
		}
		
		
		return arr;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {12,11,13,5,6,15,1};
		int[] newArr = sort(arr);
		for(int i : newArr) {
			System.out.println(i);
		}
		
		
	}

}
