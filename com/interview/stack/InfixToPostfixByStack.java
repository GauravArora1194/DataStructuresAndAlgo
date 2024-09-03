package com.interview.stack;

import java.util.Stack;

public class InfixToPostfixByStack {

	// higher returned value means higher precedence order
	public static int precedenceOrder(char operator) {

		switch (operator) {

		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;

		}
		return -1;
	}

	public static String infixToPostfix(String exp) {

		String result = new String("");

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {

			char c = exp.charAt(i);

			if (Character.isLetterOrDigit(c)) {
				result = result + c;
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {

				while (stack.peek() != '(' && !stack.empty()) {
					result = result + stack.pop();
				}

				if (stack.empty()) {
					return "Invalid Expression!";
				} else {
					stack.pop();
				}
			} else {

				while (!stack.empty() && precedenceOrder(c) <= precedenceOrder(stack.peek())) {
					result = result + stack.pop();
				}
				stack.push(c);
			}

		}

		while (!stack.empty()) {
			result = result + stack.pop();
		}

		return result;
	}

	public static void main(String[] args) {

		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(infixToPostfix(exp));

	}
}
