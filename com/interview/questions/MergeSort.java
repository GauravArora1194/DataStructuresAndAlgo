package com.interview.questions;

public class MergeSort {

	
	public static void mergeSort(int[] arr, int l, int h) {
		
		int mid = (l+h)/2;
		
		if(h > l) {
			
			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, h);
			
			merge(arr,l,mid,h);
			
		}
		
		
		
	}
	
	public static void merge(int[] arr, int l, int m, int h) {
		
		int n1 = m-l+1;
		int n2 = h-m;
		
		//create temp arrays
		int[] l1 = new int[n1];
		int[] l2 = new int[n2];
		
		//copy data to temp arrays
		for(int i =0; i < n1; i++)
			l1[i] = arr[l+i];
		for(int j =0; j < n2; j++)
			l2[j] = arr[m+1+j];
		
		
		int i=0,j=0,k=l;
		
		while(i < n1 && j < n2) {
			
			if(l1[i] <= l2[j]) {
				arr[k] = l1[i];
				i++;
			}else {
				arr[k] = l2[j];
				j++;
			}
			k++;
		}
		
		while(i < n1) {
			arr[k] = l1[i];
			i++;
			k++;
		}
		
		while(j < n2) {
			arr[k] = l2[j];
			j++;
			k++;
		}
	}
	
	
	public static void main(String[] args) {
		
		
		int[] arr = {12,11,1,13,5,6,7,34,3,0};
		mergeSort(arr, 0, arr.length-1);
		
		for(int i : arr) {
			System.out.println(i);
		}
	}
}
