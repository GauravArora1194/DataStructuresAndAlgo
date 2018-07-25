package com.interview.sortings;

public class HeapSort {

	
	public static void heapSort(int[] arr) {
		
		int size = arr.length;
		
		//Build heap from array
		for(int i= size/2 - 1; i>=0; i-- ) {
			heapify(arr, i, size);
		}
		
		for(int i = size-1; i>0; i--) {
			
			//Move largest element at the end
			arr[0] = arr[0] + arr[i];
			arr[i] = arr[0] - arr[i];
			arr[0] = arr[0] - arr[i];
			
			heapify(arr, 0, i);
		}
	}
	
	
	public static void heapify(int[] arr, int i, int size) {
		
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		//Check if left element is larger than root
		if(left < size && arr[left] > arr[largest]) {
			largest = left;
		}
		
		//Check if right element is larger
		if(right < size && arr[right] > arr[largest]) {
			largest = right;
		}
		
		//if root is not largest
		if(largest != i) {
			
			//swap root element with larger element
			arr[i] = arr[i] + arr[largest];
			arr[largest] = arr[i] - arr[largest];
			arr[i] = arr[i] - arr[largest];
			
			heapify(arr, largest, size);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		
		
		int[] arr = {12,11,13,5,6,7,1,4,20};
		
		heapSort(arr);
		
		for (int i : arr)
			System.out.println(i);
	}
}
