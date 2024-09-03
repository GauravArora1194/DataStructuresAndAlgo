package com.interview.strings;

import java.util.Stack;

/**
 * 
 * https://www.geeksforgeeks.org/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/
 * 
 * @author gauravarora02
 *
 */
public class MinimumBracketReversal {

	public static void main(String[] args) {

		String str = "}{{}}{{{";

		System.out.println(getMinCount(str));
		System.out.println(getMinCountOptimized(str));
		System.out.println(Math.ceil(0.0 + 1)/2);
	}

	// Space complexity - O(n)
	// Time complexity - O(n)
	public static int getMinCount(String str) {

		// Remove the balanced parenthesis from the string and count min reversal from
		// the remaining string

		int result = 0;

		int strLength = str.length();

		if (strLength % 2 != 0) {
			return -1;
		}

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < strLength; i++) {

			char c = str.charAt(i);

			if (!stack.isEmpty() && c == '}') {

				if (stack.peek() == '{') {
					stack.pop();
				} else {
					stack.push(c);
				}

			} else {
				stack.push(c);
			}
		}

		// string is already balanced
		if (stack.isEmpty()) {
			return 0;
		} else {

			int unbalancedLength = stack.size();

			int openCount = 0;

			while (!stack.isEmpty() && stack.peek() == '{') {

				stack.pop();
				openCount++;
			}

			result = unbalancedLength / 2 + openCount % 2;
		}

		return result;
	}

	public static int getMinCountOptimized(String str) {

		int result = 0;

		int strLength = str.length();

		if (strLength % 2 != 0) {
			return -1;
		}

		int leftBracketCount = 0;
		int rightBracketCount = 0;

		for (int i = 0; i < strLength; i++) {

			char c = str.charAt(i);

			if (c == '{') {
				leftBracketCount++;
			} else {

				if (leftBracketCount == 0) {
					rightBracketCount++;
				} else {
					leftBracketCount--;
				}
			}
		}

		if (leftBracketCount == 0 && rightBracketCount == 0) {
			return 0;

		}

		result = (int) (Math.ceil(0.0 + leftBracketCount) + Math.ceil(0.0 + rightBracketCount) / 2);

		return result;
	}
}
