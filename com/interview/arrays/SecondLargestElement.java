package com.interview.arrays;

public class SecondLargestElement {

	
	//another approach is to used bubble sort with only 2 times loop
	public static void main(String[] args) {
		
		int[] arr = {1,5,7,3,2,8,6,9,10,12,23,35,15,16,17,27};
		
		int max1;
		int max2;
		
		if(arr[0] > arr[1]) {
			max1 = arr[0];
			max2 = arr[1];
		}else {
			max1 = arr[1];
			max2 = arr[0];
		}
		
		for(int i = 2 ; i < arr.length; i++) {
			
			if(arr[i] > max1) {
				max2 = max1;
				max1 = arr[i];
				
			}else if(arr[i] > max2) {
				max2 = arr[i];
			}
			
		}
		
		System.out.println("Largest Element is : " + max1);
		System.out.println("Second Largest Element is : " + max2);
	}
	
}
