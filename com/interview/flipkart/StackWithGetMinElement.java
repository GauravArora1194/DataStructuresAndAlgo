package com.interview.flipkart;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
 * 
 * Design a stack that supports getMin() in O(1) time and O(1) extra space
 * 
 * @author gauravarora02
 *
 */
public class StackWithGetMinElement {

	Stack<Integer> stack;
	int minElement;

	public StackWithGetMinElement() {
		this.stack = new Stack<>();
	}

	public void push(int item) {

		if (stack.isEmpty()) {
			minElement = item;
			stack.push(item);
		} else {

			if (item >= minElement) {
				stack.push(item);
			} else {

				stack.push(2 * item - minElement);
				minElement = item;

			}
		}
	}

	public int pop() {

		if (stack.peek() >= minElement) {
			return stack.pop();
		} else {

			int item = minElement;
			minElement = 2 * item - stack.pop();
			return item;
		}
	}

	public int getMin() {
		return minElement;
	}

	public static void main(String[] args) {

		StackWithGetMinElement s = new StackWithGetMinElement();
		s.push(18);
		s.push(19);
		s.push(29);
		s.push(15);
		s.push(16);
		System.out.println(s.getMin());
		s.pop();
		s.pop();
		System.out.println(s.getMin());
		s.push(5);
		System.out.println(s.getMin());
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println((long) (Integer.MIN_VALUE + Integer.MIN_VALUE) - Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
	}

}
