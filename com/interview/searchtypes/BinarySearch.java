package com.interview.searchtypes;

public class BinarySearch {

	public static int search(int[] arr, int item) {
		
		int beg = 0;
		int end = arr.length-1;
		int mid = (beg + end ) / 2;
		while(beg <= end) {
			if(item == arr[mid]) {
				return mid;
			}
			else if (item < arr[mid] ) {
				end = mid-1;
				mid = (beg + end) / 2;
			}else {
				beg = mid+1;
				mid = (beg + end) / 2; 
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6};
		System.out.println(search(arr, 1));
		System.out.println(search(arr, 2));
		System.out.println(search(arr, 3));
		System.out.println(search(arr, 4));
		System.out.println(search(arr, 5));
		System.out.println(search(arr, 6));
		System.out.println(search(arr, 7));
	}
}
