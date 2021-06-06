package com.interview.questions;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

	// Using sieve of eratosthenes method

	public static List<Integer> getPrimeNumbers(int n) {

		boolean[] arr = new boolean[n + 1];

		List<Integer> list = new ArrayList<>();

		for (int i = 2; i * i <= n; i++) {

			if (!arr[i]) {

				for (int j = 2 * i; j <= n; j = j + i) {

					arr[j] = true;
				}

			}

		}

		for (int i = 2; i <= n; i++) {

			if (!arr[i]) {

				list.add(i);
			}
		}

		return list;
	}

	public static boolean checkIfNumberIsPrime(int number) {

		int count = 2;

		while (count * count <= number) {

			if (number % count == 0) {

				return false;
			}

			count++;
		}

		return true;

	}

	public static int mySqrt(int x) {

		if (x == 0 || x == 1) {
			return x;
		}

		int i = 1;

		while (i * i <= x) {

			i++;
		}

		return i - 1;

	}
	
	 public static void merge(int[] nums1, int m, int[] nums2, int n) {
	     
	        int[] arr = new int[m + n];
	        
	        for(int i = 0; i < m + n; i++){
	            
	            if(i < m) {
	                arr[i] = nums1[i];   
	            } else {
	                arr[i] = 0;
	            }
	            
	        }
	        
	        nums1 = arr;
	        
	        int i = 0;
	        int j = 0;
	        
	        while(i < nums1.length && j < nums2.length) {
	            
	            if(nums1[i] == 0) {
	                nums1[i] = nums2[j];
	                i++;
	                j++;
	            } else if(nums1[i] < nums2[j]) {
	                i++;
	            } else {
	                int temp = nums1[i];
	                nums1[i] = nums2[j];
	                nums2[j] = temp;
	                i++;
	            }
	        }
	        
	    }

	public static void main(String[] args) {

		List<Integer> list = getPrimeNumbers(50);

		for (int i : list) {
			System.out.print(i + " ");
		}

		System.out.println();

		System.out.println(list.size());

		System.out.println(mySqrt(2147395600));
		
		int[] nums1 = {1,2,3};
		int[] nums2 = {2,5,6};
		merge(nums1, 3, nums2, 3);
		// boolean isPrime = checkIfNumberIsPrime(53);

		// System.out.println(isPrime);
	}

}
