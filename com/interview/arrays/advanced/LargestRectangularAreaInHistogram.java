package com.interview.arrays.advanced;

import java.util.Stack;

public class LargestRectangularAreaInHistogram {

	public static int getMaxArea(int[] arr) {

		Stack<Integer> stack = new Stack<>();

		int maxArea = 0; // Initialize max area.
		int tp; // To store top of stack
		int areaWithTop; // To store area with top bar as the smallest bar

		// Run through all bars of given histogram
		int i = 0;

		while (i < arr.length) {
			// If this bar is higher than the bar on top stack, push it to stack
			if (stack.empty() || arr[stack.peek()] <= arr[i])
				stack.push(i++);

			// If this bar is lower than top of stack, then calculate area of rectangle
			// with stack top as the smallest (or minimum height) bar. 'i' is
			// 'right index' for the top and element before top in stack is 'left index'
			else {
				tp = stack.pop(); // store the top index
				// stack.pop(); // pop the top

				// Calculate the area with arr[tp] stack as smallest bar
				areaWithTop = arr[tp] * (stack.empty() ? i : i - stack.peek() - 1);

				// update max area, if needed
				if (maxArea < areaWithTop)
					maxArea = areaWithTop;
			}
		}

		// Now pop the remaining bars from stack and calculate area with every
		// popped bar as the smallest bar
		while (stack.empty() == false) {
			tp = stack.pop();
			// stack.pop();
			areaWithTop = arr[tp] * (stack.empty() ? i : i - stack.peek() - 1);

			if (maxArea < areaWithTop)
				maxArea = areaWithTop;
		}

		return maxArea;

	}

	public static int calculateMaxArea(int[] arr) {

		int maxArea = 0;

		int[] rb = new int[arr.length];
		int[] lb = new int[arr.length];

		rb[arr.length - 1] = arr.length;
		lb[0] = -1;
		Stack<Integer> stack1 = new Stack<>();
		stack1.push(arr.length - 1);

		Stack<Integer> stack2 = new Stack<>();
		stack2.push(0);

		for (int i = arr.length - 2; i >= 0; i--) {

			if (!stack1.isEmpty() && arr[i] < arr[stack1.peek()]) {
				stack1.pop();
			}

			if (stack1.isEmpty()) {
				rb[i] = arr.length;
			} else {
				rb[i] = stack1.peek();
			}

			stack1.push(i);
		}

		for (int i = 0; i < arr.length; i++) {

			if (!stack2.isEmpty() && arr[i] < arr[stack2.peek()]) {
				stack2.pop();
			}

			if (stack2.isEmpty()) {
				lb[i] = -1;
			} else {
				lb[i] = stack2.peek();
			}

			stack2.push(i);
		}

		for (int i = 0; i < arr.length; i++) {
			int width = rb[i] - lb[i] - 1;
			int area = arr[i] * width;

			if (area > maxArea) {
				maxArea = area;
			}
		}

		return maxArea;
	}

	public static void main(String[] args) {

		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println("Maximum area is " + getMaxArea(hist));
		System.out.println("Maximum area is " + calculateMaxArea(hist));
		System.out.println(('1' - '0'));
	}
}
