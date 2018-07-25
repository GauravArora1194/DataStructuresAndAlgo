package com.interview.arrays;

public class BinarySearchInSortedAndRotatedArray {
	
	
	//Step1 - find index of the pivot (pivot is the element for which next element is smaller than it).
	//Step2 - divide the array in two sub-arrays and apply binary search.
	
	//3 4 5 6 1 2 -> index of 5
	
	public static int findPivot(int[] arr,int start, int end) {
		
		int mid =(start+end)/2;
		
		if(arr[mid]>arr[mid+1]) {
			return mid;
		}
		
		
		return 0;
		
	}
	
	public static int getPivot(int[] arr) {
		
		
		for (int i = 0 ; i < arr.length -1 ; i++) {
		
			if(arr[i+1] < arr[i]) {
				return i;
			}
			
		}
		
		
		return 0;
	}
	
	
	public static int findElement(int[] arr, int data) {{
		
		int pivot = getPivot(arr);
		
		int temp1[] = new int[pivot+1];
		int temp2[] = new int[arr.length-(pivot+1)];
		
		for (int i = 0 ; i <= pivot ; i++) {
			temp1[i] = arr[i];
		}
		
		for (int i = pivot + 1, j = 0 ; i < arr.length; i++) {
				
			temp2[j] = arr[i];
			j++;
		}
		
		
		if(data >= temp1[0]) {
			//search in first array
			
			for(int i = 0; i< temp1.length; i++) {
				if(data == temp1[i]) {
					return i;
				}
			}
		}else {
			//search in second array
			
			for(int i = 0 ; i < temp2.length ; i++) {
				if(data == temp2[i]) {
					return pivot+1+i;
				}
			}
		}
		return -1;
	}
		
	}
	
	
	public static void main(String[] args) {
		
		int arr[] = {3,4,5,6,7,8,1,2};
		for(int i : arr) {
			System.out.print(i);
		}
		
		int pivot = getPivot(arr);
		
		System.out.println("\n" + pivot);
		
		System.out.println("Element is present at index : " + findElement(arr, 2));
		
		
	}
	

}
