package com.interview.sortings;

public class MergeSort {

	
	private static int[] mergeSort(int[] arr, int low, int high) {
		
		
		if(low == high) {
			int[] baseArr = new int[1];
			baseArr[0] = arr[low];
			return baseArr;
		}
		
		
		int mid = (low + high ) / 2;
		
		int[] firstHalf = mergeSort(arr, low, mid);
		int[] secondHalf = mergeSort(arr, mid + 1, high);
		
		int[] sorted = merge(firstHalf, secondHalf);
		
		return sorted;
		
		
	}
	
	private static int[] merge(int[] first, int[] second) {
		
		int[] merged = new int[first.length + second.length];
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < first.length && j < second.length) {
			
			if(first[i] < second[j]) {
				merged[k] = first[i];
				i++;
				k++;
			} else {
				merged[k] = second[j];
				j++;
				k++;
			}
		}
		
		
		while( j < second.length) {
			merged[k] = second[j];
			j++;
			k++;
		}
		
		
		while( i < first.length) {
			merged[k] = first[i];
			i++;
			k++;
		}
		
		
		return merged;
	}
	
	public static void main(String[] args) {
		
		
		int[] arr = {12,11,1,13,5,6,7,34,3,0};
		int[] sortedArr =  mergeSort(arr, 0, arr.length-1);
		
		for(int i : sortedArr) {
			System.out.print(i + " ");
		}
	}
}
