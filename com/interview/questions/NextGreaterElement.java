package com.interview.questions;

import java.util.Stack;

public class NextGreaterElement {

	public static int[] nextGreaterElement(int[] arr) {

		int[] result = new int[arr.length];
		int j;
		for (int i = 0; i < arr.length; i++) {

			for (j = i + 1; j < arr.length; j++) {

				if (arr[j] > arr[i]) {

					result[i] = arr[j];
					break;
				}
			}

			if (j == arr.length)
				result[i] = -1;
		}

		return result;
	}

	// Another Approach using stack
	// 1. push the element in stack if-
	// a. Stack is empty
	// b.the element is less than or equal to the top element
	// 2.If the element is greater than the top element,then pop the element till
	// the element is less than or equal to
	// the top element(or stack is empty)

	public static void NGEUsingStack(int[] arr) {

		Stack<Integer> stack = new Stack<>();

		stack.push(arr[0]);

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] < stack.peek()) {
				stack.push(arr[i]);
			} else {

				while (!stack.empty()) {
					System.out.println(stack.pop() + " -> " + arr[i]);
				}

				stack.push(arr[i]);
			}
		}

		while (!stack.empty()) {
			System.out.println(stack.pop() + " -> -1");
		}
	}

	public static void main(String[] args) {

		int[] arr = { 11, 13, 21, 3, 25 };

		int[] result = nextGreaterElement(arr);

		for (int i : result)
			System.out.print(i + " ");

		// using stack approach
		System.out.println("\nUsing stack approach : ");
		NGEUsingStack(arr);

		Integer i1 = 127;
		Integer i2 = 127;

		System.out.println(i1 == i2);

		Integer i3 = 128;
		Integer i4 = 128;

		System.out.println(i3 == i4);
	}
}
