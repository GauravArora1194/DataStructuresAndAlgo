package com.interview.strings;

/**
 * 
 * search pattern in a text using hashing technique
 * 
 * @author gauravarora02
 *
 */
public class RabinKarpSearch {

	private static int PRIME = 101;

	public static void main(String[] args) {

		String s = "GEEKS FOR GEEKS";
		String p = "GEEK";

		searchPattern(s, p);
	}

	public static void searchPattern(String text, String pattern) {

		int count = 0;

		char[] t = text.toCharArray();
		char[] p = pattern.toCharArray();

		int pattHash = computeHash(p, p.length - 1);
		int textHash = computeHash(t, p.length - 1);

		for (int i = 1; i <= t.length - p.length + 1; i++) {

			if (pattHash == textHash && checkIfEqual(t, i - 1, i + p.length - 2, p, 0, p.length - 1)) {
				System.out.println(i - 1);
				count++;
			}

			if (i < t.length - p.length + 1 && (i + p.length - 1) < t.length) {
				textHash = recomputeHash(t, i - 1, i + p.length - 1, textHash, p.length);
			}
		}

		if (count == 0)
			System.out.println(-1);
	}

	private static int recomputeHash(char[] str, int oldIndex, int newIndex, int oldHash, int patternLength) {

		int hash = oldHash - str[oldIndex];
		hash = hash / PRIME;
		hash += str[newIndex] * Math.pow(PRIME, patternLength - 1);

		return hash;
	}

	private static boolean checkIfEqual(char[] str1, int start1, int end1, char[] str2, int start2, int end2) {

		if (end1 - start1 != end2 - start2) {

			return false;
		}

		while (end2 >= start2 && end1 >= start1) {

			if (str1[start1] != str2[start2]) {
				return false;
			}

			start1++;
			start2++;
		}

		return true;
	}

	public static int computeHash(char[] str, int endIndex) {

		int hash = 0;

		for (int i = 0; i <= endIndex; i++) {
			hash += str[i] * Math.pow(PRIME, i);
		}

		return hash;
	}
}
