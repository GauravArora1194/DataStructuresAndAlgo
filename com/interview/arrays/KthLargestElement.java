package com.interview.arrays;

public class KthLargestElement {

	
	
	public static int heapSort(int[] arr, int k) {
		
		int size = arr.length;
		
		//Build the max heap from array
		for(int i = size/2 - 1; i >= 0; i--) {
			heapify(arr,i,size);
		}
		
		for(int i = size - 1; i >= size-k; i--) {
			
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heapify(arr,0,i);
		}
		
		return arr[size-k];
		
		
	}
	
	
	public static void heapify(int[] arr, int i , int size) {
		
		
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		if(left < size && arr[left] > arr[largest])
			largest = left;
		
		if(right < size && arr[right] > arr[largest])
			largest = right;
		
		if(largest != i) {
			
			// swap element at largest with element at i
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			
			heapify(arr, largest, size);
		}
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {7, 10, 4, 3, 20, 15};
		int k=6;
		
		System.out.println(k + "th largest element is : " + heapSort(arr,k));
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
}
