package com.interview.dynamic.programming;

public class PalindromeSubstringTabulized {

	public static int palindromeSubstring(String str) {

		boolean[][] strgMatrix = new boolean[str.length()][str.length()];
		
		

		int counter = 0;

		for (int diag = 0; diag < str.length(); diag++) {

			int si = 0;
			int ei = diag;

			while (ei < str.length()) {

				if (diag == 0) {
					strgMatrix[si][ei] = true;
				} else if (diag == 1) {

					if (str.charAt(si) == str.charAt(ei)) {
						strgMatrix[si][ei] = true;
					}
				} else {

					if (str.charAt(si) == str.charAt(ei) && strgMatrix[si + 1][ei - 1] == true) {
						strgMatrix[si][ei] = true;
					}
				}

				if (strgMatrix[si][ei] == true)
					counter++;
				
				

				si++;
				ei++;
			}
		}

		return counter;
	}

	public static void main(String[] args) {

		System.out.println(palindromeSubstring("abccbc"));
	}
}
