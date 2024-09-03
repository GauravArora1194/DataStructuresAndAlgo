package com.interview.strings;

/**
 * 
 * Count palindromic substrings in a string
 * 
 * @author gauravarora02
 *
 */
public class CountPalindromicSubStrings {

	public static void main(String[] args) {

		String str = "aaaa";
		System.out.println(getCount(str));
	}

	public static int getCount(String str) {

		int[][] dp = new int[str.length()][str.length()];

		for (int gap = 0; gap < str.length(); gap++) {

			for (int si = 0, ei = gap; ei < str.length(); si++, ei++) {

				if (gap == 0) {
					dp[si][ei] = 1;

				} else if (gap == 1) {
					dp[si][ei] = str.charAt(si) == str.charAt(ei) ? 3 : 2;

				} else {

					if (str.charAt(si) == str.charAt(ei)) {
						dp[si][ei] = dp[si][ei - 1] + dp[si + 1][ei] + 1;

					} else {

						dp[si][ei] = dp[si][ei - 1] + dp[si + 1][ei] - dp[si + 1][ei - 1];
					}
				}
			}
		}

		return dp[0][str.length() - 1];
	}
}
