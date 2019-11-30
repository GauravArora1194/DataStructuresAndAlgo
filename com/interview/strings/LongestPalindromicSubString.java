package com.interview.strings;

public class LongestPalindromicSubString {

	public static void getLongestPalindromeString(String str) {

		boolean[][] matrix = new boolean[str.length()][str.length()];

		int counter = 0;

		int max = 0;
		String palindrome = "";

		for (int diag = 0; diag < str.length(); diag++) {

			int si = 0;
			int ei = diag;

			while (ei < str.length()) {

				if (diag == 0) {
					matrix[si][ei] = true;
				} else if (diag == 1) {
					if (str.charAt(si) == str.charAt(ei)) {
						matrix[si][ei] = true;
					}
				} else {
					if (str.charAt(si) == str.charAt(ei) && matrix[si + 1][ei - 1] == true) {
						matrix[si][ei] = true;
					}
				}

				if (matrix[si][ei] == true) {
					counter++;
					int subStringLength = str.substring(si, ei + 1).length();
					if (subStringLength > max) {
						max = subStringLength;
						palindrome = str.substring(si, ei + 1);
					}
				}

				si++;
				ei++;

			}

		}

		if (counter != 0) {
			System.out.println("Total palindrome : " + counter);
			System.out.println("Longest palindrome : " + palindrome + " and length is :" + palindrome.length());
		} else {
			System.out.println("No palindrome exist!");
		}

	}

	public static void main(String[] args) {

		String str = "abccbc";
		String str1 = "forgeeksskeegfor";
		String str3 = "abc";
		getLongestPalindromeString(str);
		getLongestPalindromeString(str1);
		getLongestPalindromeString(str3);

	}

}
