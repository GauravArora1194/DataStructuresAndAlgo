package com.interview.arrays;

public class PrintsFrequencyOfElements {

	
	// prints the frequency of elements in an array in O(n) time and O(1) space
	
	 void printfrequency(int arr[], int n) 
	    {
	        // Subtract 1 from every element so that the elements
	        // become in range from 0 to n-1
	        for (int j = 0; j < n; j++)
	            arr[j] = arr[j] - 1;
	 
	        // Use every element arr[i] as index and add 'n' to
	        // element present at arr[i]%n to keep track of count of
	        // occurrences of arr[i]
	        for (int i = 0; i < n; i++)
	            arr[arr[i] % n] = arr[arr[i] % n] + n;
	 
	        // To print counts, simply print the number of times n
	        // was added at index corresponding to every element
	        for (int i = 0; i < n; i++)
	            System.out.println(i + 1 + "->" + arr[i] / n);
	    }
	 
	 // prints the element with max frequency in O(n) time and O(1) space
	 
	 void printMaxFrequencyElement(int[] arr) {
		 
		 int n = arr.length;
		 int max = 0;
		 int index = 0;
		 
		 for(int i = 0; i < n; i++) {
			 
			 arr[arr[i]%n] = arr[arr[i]%n] + n;
		 }
		 
		 for(int i = 0 ; i < n; i++) {
			 if(arr[i] > max) {
				 max = arr[i];
				 index = i;
			 }
		 }
		 
		 System.out.println("Max Frequency element is : " + index);
		 
	 }
	 
	 public static void main(String[] args) {
		
		 	PrintsFrequencyOfElements count = new PrintsFrequencyOfElements();
	        int arr[] = {2, 3, 3, 2, 5};
	        int n = arr.length;
	        count.printfrequency(arr, n);
	        count.printMaxFrequencyElement(arr);
	}
}
