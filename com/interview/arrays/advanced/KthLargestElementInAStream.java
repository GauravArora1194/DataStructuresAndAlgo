package com.interview.arrays.advanced;

public class KthLargestElementInAStream {

	// finds the kth largest element in a stream at any point
	
	
	public static int findKthLargest(int[] arr, int k) {
		
		// min heap to store k largest element
		int[] minHeap = new int[k];
		
		for(int i = 0; i < arr.length; i++) {
			
			if(i < k - 1)
				minHeap[i] = arr[i];
			else if(i == k - 1) {
				minHeap[i] = arr[i];
				buildMinHeap(minHeap, k);
				System.out.println("Kth largest element is : " + minHeap[0]);
			}else {
				
				if(arr[i] > minHeap[0]) {
					minHeap[0] = arr[i];
					heapify(minHeap, 0, k);
					System.out.println("Kth largest element is : " + minHeap[0]);
				}
			}
		}
		
		
		return minHeap[0];
	}

	private static void heapify(int[] minHeap, int i, int size) {
		
		int smallest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		if (left < size && minHeap[left] < minHeap[smallest])
			smallest = left;
		
		if (right < size && minHeap[right] < minHeap[smallest])
			smallest = right;
		
		if(smallest != i) {
			
			int temp = minHeap[smallest];
			minHeap[smallest] = minHeap[i];
			minHeap[i] = temp;
			
			heapify(minHeap, smallest, size);
		}
		
	}

	private static void buildMinHeap(int[] minHeap, int k) {
		
		for(int i = k/2 -1; i >= 0; i--)
			heapify(minHeap, i, k);
		
	}
	
	
	
	public static void main(String[] args) {
		
		int[] arr = {10, 20, 11, 70, 50, 40, 100, 5};
		System.out.println("Kth largest element is : " + findKthLargest(arr, 3));
		
		
	}
}
