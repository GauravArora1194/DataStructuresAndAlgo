package com.interview.stack;

import java.util.Stack;

public class BalancedParenthesisByStack {

	public static  Stack<Character> stack = new Stack<>();

	public static boolean isMatchingPair(char first, char second) {

		if (first == '(' && second == ')')
			return true;
		else if (first == '[' && second == ']')
			return true;
		else if (first == '{' && second == '}')
			return true;
		else
			return false;
	}

	public static boolean isBalancedExpression(String exp) {

		for (int i = 0; i < exp.length(); i++) {

			if (exp.charAt(i) == '(' || exp.charAt(i) == '{' || exp.charAt(i) == '[') {

				stack.push(exp.charAt(i));
				System.out.println(exp.charAt(i)+ " pushed into stack");

			} else if (exp.charAt(i) == ')' || exp.charAt(i) == '}' || exp.charAt(i) == ']') {

				if (stack.empty()) {
					return false;
				} else if (!isMatchingPair(stack.pop(), exp.charAt(i))) {

					return false;

				}

			}

		}

		if (stack.empty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		String exp1 ="[()] {}{[()()]()}";
		
		System.out.println("Is Expression1 is balanced  : "+ isBalancedExpression(exp1) );
		
		String exp2 = "[(])";
		
		System.out.println("Is Expression2 is balanced  : "+ isBalancedExpression(exp2) );
		
		//Time complexity : O(n)
		//Auxiliary space : O(n) for stack.
	}
}
