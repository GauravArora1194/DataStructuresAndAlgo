package com.interview.sortings;

public class BubbleSortWithRecusrion {

	
	public static void bubbleSort(int[] arr, int start, int last) {
		
		if(last == 0) {
			return;
		}
		
		if(start == last) {
			bubbleSort(arr, 0, last - 1);
			return;
		}
		
		
		if(arr[start] > arr[start + 1]) {
			int temp = arr[start];
			arr[start] = arr[start + 1];
			arr[start + 1] = temp;
		}
		
		bubbleSort(arr, start + 1, last);
	}
	
	public static void main(String[] args) {
		
		int[] arr = {5,9,23,9,2,9,1,9};
		bubbleSort(arr, 0, arr.length-1);
		
		for(int i : arr) {
			System.out.println(i);
		}
	}
	
}
