package com.interview.arrays;

public class ArrayReversal {

	public static void reverse(int[] arr) {

		int begin = 0;
		int last = arr.length - 1;

		while (begin < last) {
			int temp = arr[begin];
			arr[begin] = arr[last];
			arr[last] = temp;
			begin++;
			last--;
		}

	}

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		System.out.println("original array : ");
		for (int i : arr) {
			System.out.print(i + " ");
		}

		reverse(arr);
		System.out.println("\narray after reversal : ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
