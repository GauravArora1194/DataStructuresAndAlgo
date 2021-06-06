package com.interview.arrays;

import java.util.Stack;

public class SlidingWindowMaximum {

	public static int[] nextGreaterElement(int[] arr) {

		int[] nge = new int[arr.length];
		Stack<Integer> stack = new Stack<>();

		stack.push(arr.length - 1);
		nge[arr.length - 1] = arr.length;

		for (int i = arr.length - 2; i >= 0; i--) {

			while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				nge[i] = arr.length;
			} else {
				nge[i] = stack.peek();
			}

			stack.push(i);
		}

		return nge;

	}

	public static void slidingWindowMax(int[] arr, int size) {

		int[] nge = nextGreaterElement(arr);

		int j = 0;

		for (int i = 0; i <= arr.length - size; i++) {
			// enter the loop to find maximum of window starting at i.

			if (j < i) {
				j = i;
			}

			while (nge[j] < i + size) {

				j = nge[j];
			}

			System.out.println(arr[j]);
		}
	}

	public static void main(String[] args) {

		int[] arr = { 12, 1, 78, 90, 57, 89, 56 };
		int k = 3;

		slidingWindowMax(arr, k);
	}
}
