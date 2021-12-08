package com.interview.matrix;

import java.util.Stack;

/**
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest
 * rectangle containing only 1's and return its area.
 * 
 * @author gauravarora02
 *
 */
public class MaximumSizeRectangle {

	public static void main(String[] args) {

		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };

		System.out.println(maximalRectangle(matrix));
	}

	public static int maximalRectangle(char[][] matrix) {

		if (matrix.length == 0) {
			return 0;
		}

		int[] temp = new int[matrix[0].length];

		int maxRect = 0;

		int rowLength = matrix.length;
		int colLength = matrix[0].length;

		for (int row = 0; row < rowLength; row++) {

			for (int col = 0; col < colLength; col++) {

				if (row == 0) {
					temp[col] = matrix[row][col] - '0';
				} else {
					if (matrix[row][col] == '1') {
						temp[col] = temp[col] + 1;
					} else {
						temp[col] = 0;
					}

				}
			}

			int area = calculateMaxArea(temp);

			if (area > maxRect) {
				maxRect = area;
			}
		}

		return maxRect;

	}

	public static int calculateMaxArea(int[] arr) {

		int i = 0;
		Stack<Integer> stack = new Stack<>();

		int maxArea = 0;

		while (i < arr.length) {

			if (stack.isEmpty() || arr[stack.peek()] <= arr[i]) {
				stack.push(i);
				i++;
			} else {

				int top = stack.pop();

				int area = arr[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);

				if (area > maxArea) {
					maxArea = area;
				}
			}

		}

		while (!stack.isEmpty()) {

			int top = stack.pop();
			int area = arr[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);

			if (area > maxArea) {
				maxArea = area;
			}
		}

		return maxArea;
	}
}
