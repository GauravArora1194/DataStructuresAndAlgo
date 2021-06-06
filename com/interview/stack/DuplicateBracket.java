package com.interview.stack;

import java.util.Stack;

public class DuplicateBracket {

	// Given an expression, checks if it contains duplicate brackets (unnecessary
	// brackets)

	public static void main(String[] args) {

		String exp = "((a+b)+(c+d))";
		String exp1 = "(a+b)+((c+d))";

		System.out.println(checkIfContainsDuplicateBracket(exp));
		System.out.println(checkIfContainsDuplicateBracket(exp1));
	}

	protected static boolean checkIfContainsDuplicateBracket(String exp) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {

			char c = exp.charAt(i);

			if (c == ')') {

				if (stack.peek() == '(') {
					return true;
				} else {

					while (stack.peek() != '(') {

						stack.pop();
					}

					stack.pop();
				}

			} else {

				stack.push(c);
			}
		}

		return false;

	}
}
