package com.interview.stack;

import java.util.Stack;

public class SpecialStack extends Stack<Integer> {

	private static final long serialVersionUID = 1L;

	Stack<Integer> minStack = new Stack<>();

	public static void main(String[] args) {

		SpecialStack s = new SpecialStack();
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

	}

	public void push(int item) {

		if (isEmpty()) {

			minStack.push(item);

		} else {

			if (item < minStack.peek()) {
				minStack.push(item);
			}

		}

		super.push(item);

	}

	public Integer pop() {

		int top = super.peek();

		if (top == minStack.peek()) {
			minStack.pop();
		}

		return super.pop();

	}

	public Integer getMin() {

		return minStack.peek();
	}

}
