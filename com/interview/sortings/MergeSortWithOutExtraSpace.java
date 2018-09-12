package com.interview.sortings;

public class MergeSortWithOutExtraSpace {

	
	private static void mergeSort(int[] arr, int low, int high) {
		
			if(low >= high) {
				return;
			}
		
			
			int mid = (low + high) / 2;
			
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			
			merge(arr, low, mid, high);
		
		
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		
		
		int i = low;
		int j = mid + 1;
		
		int[] temp = new int[high - low + 1];
		int k = 0;
		
		while(i <= mid && j <= high) {
			
			if(arr[i] < arr[j]) {
				temp[k] = arr[i];
				i++;
				k++;
			}else {
				temp[k] = arr[j];
				j++;
				k++;
				
			}
		}
		
		while(i <= mid) {
			temp[k] = arr[i];
			i++;
			k++;
		}
		
		while(j <= high) {
			temp[k] = arr[j];
			j++;
			k++;
		}
		
		for(int l = 0; l < temp.length; l++) {
			arr[low] = temp[l];
			low++;
		}
	}
	
	
	public static void main(String[] args) {
		
		
		int[] arr = {12,11,1,13,5,6,7,34,3,0};
		
		mergeSort(arr, 0, arr.length-1);
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
	
}
