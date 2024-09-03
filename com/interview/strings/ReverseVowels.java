package com.interview.strings;

public class ReverseVowels {

	public static String reverseVowels(String s) {

		char[] c = s.toCharArray();
		int start = 0;
		int end = s.length() - 1;

		while (start < end) {

			while (start < end && !isVowel(c[start])) {
				start++;
			}

			while (start < end && !isVowel(c[end])) {
				end--;
			}

			if (start < end) {

				char c1 = c[start];
				c[start] = c[end];
				c[end] = c1;
				start++;
				end--;

			}

		}

		return new String(c);

	}

	public static boolean isVowel(char c) {

		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

	public static void main(String[] args) {

		System.out.println(reverseVowels("leetcode"));
	}

}
