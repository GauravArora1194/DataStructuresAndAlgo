package com.interview.arrays;

public class MissingNumberInArray {

	public static void main(String[] args) {

		// int[] arr = {1,2,4,6,3,7,8};
		int[] arr = { 1, 2, 4, 5, 6 };

		int arrXor = arr[0];
		int numXor = 1;

		for (int i = 1; i < arr.length; i++) {
			arrXor = arrXor ^ arr[i];
		}

		for (int i = 2; i <= arr.length + 1; i++) {
			numXor = numXor ^ i;
		}

		System.out.println("Missing Number is : " + (numXor ^ arrXor));

	}

}
