package com.interview.questions;

public class SortOneTwoThreeArray {
	
	//Simple approach
	public static int[] sortArray(int[] arr) {
		
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;
		
		
		for(int i = 0 ; i < arr.length; i++) {
			
			if(arr[i] == 0)
				count0++;
			else if(arr[i] == 1)
				count1++;
			else count2++;
			
		}
		
		for(int i = 0; i < arr.length; i++) {
			
			while(count0 != 0) {
				arr[i] = 0;
				i++;
				count0--;
			}
			
			while(count1 != 0) {
				arr[i] = 1;
				i++;
				count1--;
			}
			
			while(count2 != 0) {
				arr[i] = 2;
				i++;
				count2--;
			}
		}
		
		return arr;
		
	}

	
	public static void swap(int a, int b) {
		
		a = a+b;
		b = a-b;
		a = a-b;
	}
	//Another approach(Dutch National flag algorithm)
	public static int[] sort(int[] arr) {
		
		int low= 0;
		int mid = 0;
		int high = arr.length - 1;
		
		while(mid <= high) {
			
			switch(arr[mid]) {
			
			case 0 : //swap low and mid
					if(arr[mid] != arr[low]) {
						arr[low] = arr[low] + arr[mid];
						arr[mid] = arr[low] - arr[mid];
						arr[low] = arr[low] - arr[mid];
					}
					
					low++;
					mid++;
					break;
					
			case 1 : mid++;
					break;
					
			case 2 : //swap mid and high
					if(arr[mid] != arr[high]) {
						arr[mid] = arr[mid] + arr[high];
						arr[high] = arr[mid] - arr[high];
						arr[mid] = arr[mid] - arr[high];
					}
					
					high--;
					break;
			
			}
			
		}
		
		return arr;
	}
	public static void main(String[] args) {

		int[] arr = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		
		System.out.println("Original array : ");
		for(int i : arr)
			System.out.print(i + " ");
		
		//sortArray(arr);
		sort(arr);
		System.out.println("\nSorted Array : ");
		for(int i : arr)
			System.out.print(i + " ");
		
		
	}

}
