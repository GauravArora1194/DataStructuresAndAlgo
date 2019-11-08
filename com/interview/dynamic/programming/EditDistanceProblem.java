package com.interview.dynamic.programming;

public class EditDistanceProblem {

	// Given two strings str1 and str2 and below operations that can performed on
	// str1. Find minimum number of edits (operations) required to convert ‘str1’
	// into ‘str2’.

	// 1. Insert
	// 2. Remove
	// 3. Replace

	// All of the above operations are of equal cost.

	public static void main(String[] args) {

		String str1 = "sunday";
		String str2 = "saturday";

		System.out.println(editDistDP(str1, str2, str1.length(), str2.length()));
	}

	static int editDistRecursion(String str1, String str2, int m, int n) {
		// If first string is empty, the only option is to
		// insert all characters of second string into first
		if (m == 0)
			return n;

		// If second string is empty, the only option is to
		// remove all characters of first string
		if (n == 0)
			return m;

		// If last characters of two strings are same, nothing
		// much to do. Ignore last characters and get count for
		// remaining strings.
		if (str1.charAt(m - 1) == str2.charAt(n - 1))
			return editDistRecursion(str1, str2, m - 1, n - 1);

		// If last characters are not same, consider all three
		// operations on last character of first string, recursively
		// compute minimum cost for all three operations and take
		// minimum of three values.

		int insert = editDistRecursion(str1, str2, m, n - 1);
		int remove = editDistRecursion(str1, str2, m - 1, n);
		int replace = editDistRecursion(str1, str2, m - 1, n - 1);

		return 1 + Math.min(insert, // Insert
				Math.min(remove, // Remove
						replace)// Replace
		);
	}

	static int editDistDP(String str1, String str2, int m, int n) {

		// Create a table to store results of subproblems

		// Insert - table[row][col - 1]
		// Remove - table[row - 1][col]
		// Replace - table[row - 1][col - 1]

		int[][] table = new int[m + 1][n + 1];

		for (int row = 0; row <= m; row++) {

			for (int col = 0; col <= n; col++) {

				if (row == 0) {
					table[row][col] = col;
				} else if (col == 0) {
					table[row][col] = row;
				} else if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
					table[row][col] = table[row - 1][col - 1];
				} else {

					table[row][col] = 1
							+ Math.min(table[row - 1][col - 1], Math.min(table[row][col - 1], table[row - 1][col]));
				}

			}
		}

		return table[m][n];
	}

}
