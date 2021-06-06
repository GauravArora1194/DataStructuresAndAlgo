package com.interview.stack;

import java.util.Stack;

public class SmallestNumberFollowingPattern {

	public static void getNumber(String str) {

		Stack<Integer> stack = new Stack<>();

		int num = 1;

		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);

			if (c == 'd') {
				stack.push(num);
				num++;
			} else {
				stack.push(num);
				num++;

				while (!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
			}
		}

		stack.push(num);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}

	public static void main(String[] args) {

		String str = "ddiddidd";
		getNumber(str);
	}

}
