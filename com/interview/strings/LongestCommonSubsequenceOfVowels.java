package com.interview.strings;

public class LongestCommonSubsequenceOfVowels {

	public static int longestCommonSubsequence(String string1, String string2) {

		int rowLength = string1.length() + 1;
		int colLength = string2.length() + 1;

		int maxLength = 0;

		int[][] matrix = new int[rowLength][colLength];

		for (int i = 1; i < rowLength; i++) {

			for (int j = 1; j < colLength; j++) {

				if (string1.charAt(i - 1) == string2.charAt(j - 1)) {

					if ("aeiou".indexOf(string1.charAt(i - 1)) != -1) {

						matrix[i][j] = matrix[i - 1][j - 1] + 1;
					}

				} else {
					matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
				}

				if (matrix[i][j] > maxLength) {

					maxLength = matrix[i][j];
				}
			}
		}

		return maxLength;
	}

	public static void main(String[] args) {

		String str1 = "shabi";
		String str2 = "abcid";

		String str3 = "abpqrife";
		String str4 = "aiefghao";

		System.out.println("length of longest subsequence : " + longestCommonSubsequence(str1, str2));
		System.out.println("length of longest subsequence : " + longestCommonSubsequence(str3, str4));
	}
}
