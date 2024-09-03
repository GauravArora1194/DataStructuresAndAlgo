package com.interview.questions;

import java.util.Stack;

public class StockSpanProblem {

	public static void main(String[] args) {

		int[] stockPrice = { 100, 80, 60, 70, 60, 75, 85 };

		int[] spanArr = getSpanArray(stockPrice);
		int[] spanArrOptimized = calculateSpan(stockPrice);

		display(stockPrice);
		display(spanArr);
		display(spanArrOptimized);

	}

	private static int[] getSpanArray(int[] stockPrice) {

		int[] span = new int[stockPrice.length];

		span[0] = 1;

		for (int i = 1; i < stockPrice.length; i++) {

			span[i] = 1;

			for (int j = i - 1; j >= 0; j--) {

				if (stockPrice[i] > stockPrice[j]) {

					span[i] = span[i] + 1;
				}
			}
		}

		return span;
	}

	private static int[] calculateSpan(int[] stockPrice) {

		int[] span = new int[stockPrice.length];

		Stack<Integer> stack = new Stack<>();

		span[0] = 1;
		stack.push(0);

		for (int i = 1; i < stockPrice.length; i++) {

			while (!stack.isEmpty() && stockPrice[stack.peek()] <= stockPrice[i]) {
				stack.pop();
			}

			span[i] = stack.empty() ? (i + 1) : (i - stack.peek());

			stack.push(i);
		}

		return span;
	}

	private static void display(int[] stockPrice) {

		for (int i : stockPrice) {

			System.out.print(i + " ");
		}
		System.out.println();

	}

}
