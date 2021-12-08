package com.interview.strings;

public class LongestRepeatingSubsequence {

	public static void main(String[] args) {

		String str = "AABEBCDD";
		
		String str1 = "abc";
		String str2 = "aab";
		String str3 = "aabb";
		String str4 = "axxxy";

		System.out.println(longestSubsequence(str));
		
		System.out.println(longestSubsequence(str1));
		System.out.println(longestSubsequence(str2));
		System.out.println(longestSubsequence(str3));
		System.out.println(longestSubsequence(str4));
	}

	public static int longestSubsequence(String str) {

		int[][] dp = new int[str.length() + 1][str.length() + 1];

		for (int row = 1; row < dp.length; row++) {

			for (int col = 1; col < dp[0].length; col++) {

				if (str.charAt(row - 1) == str.charAt(col - 1) && row != col) {
					dp[row][col] = dp[row - 1][col - 1] + 1;
				} else {
					dp[row][col] = Math.max(dp[row][col - 1], dp[row - 1][col]);
				}
			}
		}

		return dp[dp.length - 1][dp[0].length - 1];
	}
}
