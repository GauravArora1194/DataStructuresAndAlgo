package com.interview.stack;

import java.util.Stack;

public class MaximumSlidingWindow {

	public static void main(String[] args) {

	}

	public void maxSlidingWindow(int[] arr, int k) {

		Stack<Integer> stack = new Stack<>();

		int[] nge = new int[arr.length];
		stack.push(arr.length - 1);
		nge[arr.length - 1] = arr.length;

		for (int i = arr.length - 1; i >= 0; i--) {

			while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				nge[i] = arr.length;
			} else {
				nge[i] = stack.peek();
			}

			stack.push(i);
		}

		int j = 0;

		for (int i = 0; i <= arr.length - k; i++) {

			if (j < i) {
				j = i;
			}

			while (nge[j] < i + k) {
				j = nge[j];
			}

			System.out.println(arr[j]);

		}

	}

}
