package com.interview.questions;

public class PangramCheck {

	// A pangram is a sentence containing every letter in the English Alphabet.
	// Examples : The quick brown fox jumps over the lazy dog ” is a Pangram
	// [Contains all the characters from ‘a’ to ‘z’]

	public static boolean checkForPangram(String str) {
		// by default arrays are initialized to 0
		int marked[] = new int[26];
		int index = -1;

		for (int i = 0; i < str.length(); i++) {

			// for upperCase letters
			if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
				index = str.charAt(i) - 'A';
			}
			// for lowerCase letters
			else if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
				index = str.charAt(i) - 'a';
			}

			marked[index] = 1;

		}

		for (int i = 0; i < 26; i++) {
			if (marked[i] == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		String str1 = "The quick brown fox jumps over the lazy dog";
		String str2 = "The quick brown fox jumps over the dog";
		boolean isPangram = checkForPangram(str1);
		System.out.println("Is string1 Pangram : " + isPangram);
		
		isPangram = checkForPangram(str2);
		System.out.println("Is string2 Pangram : " + isPangram);

	}
}
