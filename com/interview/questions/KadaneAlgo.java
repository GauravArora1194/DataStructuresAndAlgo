package com.interview.questions;

//largest sum contiguous sub-array
public class KadaneAlgo {

	public static void subArray(int[] arr) {

		int maxSoFar = 0;
		int maxEndingHere = 0;
		int start = 0;
		int end = 0;
		int s = 0;

		for (int i = 0; i < arr.length; i++) {

			maxEndingHere = maxEndingHere + arr[i];

			if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
				start = s;
				end = i;
			}

			if (maxEndingHere < 0) {
				maxEndingHere = 0;
				s = i + 1;
			}

		}

		System.out.println("Maximum Contiguous sum is : " + maxSoFar);
		System.out.println("Starting index : " + start);
		System.out.println("Ending index : " + end);
	}

	public static void main(String[] args) {

		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };

		subArray(arr);
	}

}
