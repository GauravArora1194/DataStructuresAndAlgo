package com.interview.dynamic.programming;

public class MaxSumIncreasingSubsequence {

	public static void LIS(int[] arr) {

		int[] sumArr = new int[arr.length];

		String[] seqArr = new String[arr.length];

		sumArr[0] = arr[0];
		seqArr[0] = arr[0] + "";

		int overallMax = sumArr[0];
		String overallPath = seqArr[0];

		for (int i = 1; i < arr.length; i++) {

			seqArr[i] = "";

			for (int j = 0; j <= i - 1; j++) {

				if (arr[j] < arr[i]) {

					if (sumArr[j] > sumArr[i]) {
						sumArr[i] = sumArr[j];
						seqArr[i] = seqArr[j];
					}
				}
			}

			sumArr[i] += arr[i];
			seqArr[i] = seqArr[i] + " " + arr[i];

			if (sumArr[i] > overallMax) {
				overallMax = sumArr[i];
				overallPath = seqArr[i];
			}
		}

		System.out.println(overallMax);
		System.out.println(overallPath);

	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {1, 101, 2, 3, 100, 4, 5};
		int[] arr1 = {3, 4, 5, 10};
		int[] arr2 = {10, 5, 4, 3};
		
		
		LIS(arr);
		LIS(arr1);
		LIS(arr2);
	}

}
