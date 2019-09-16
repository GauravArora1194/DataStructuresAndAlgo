package com.interview.recursion;

public class GenerateAllStringsOfNBits {

	public static void main(String[] args) {

		int n = 4;

		printStrings(n, "");
	}

	private static void printStrings(int n, String str) {

		if (n == 0) {
			System.out.println(str);
			return;
		}

		printStrings(n - 1, str + "0");
		printStrings(n - 1, str + "1");
	}
}
