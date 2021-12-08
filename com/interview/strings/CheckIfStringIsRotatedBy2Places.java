package com.interview.strings;

public class CheckIfStringIsRotatedBy2Places {

	// checks if the string2 is rotated by by two places of string1.

	// there is also modification of this Question-
	// i.e check if a string can be obtained by rotating another string by 2 places.

	// clockwise means elements are shifted to right
	// Anti-clockwise means elements are shifted to left

	public static boolean checkIfRotated(String str1, String str2) {

		if (str1.length() != str2.length()) {
			return false;
		}

		String clockwiseString = "";
		String anticlockwiseString = "";

		clockwiseString = clockwiseString + str2.substring(2) + str2.substring(0, 2);

		anticlockwiseString = anticlockwiseString + str2.substring(str2.length() - 2)
				+ str2.substring(0, str2.length() - 2);

		return (str1.equals(clockwiseString) || str1.equals(anticlockwiseString));

	}

	public static void main(String[] args) {

		// String str = "ABCDE";

		// clockwise = DEABC;
		// Anti-clockwise = CDEAB

		String str1 = "amazon";
		String str2 = "azonam";

		String str3 = "amazon";
		String str4 = "onamaz";

		String str5 = "amazon";
		String str6 = "noamaz";

		System.out.println("Is String 2 is rotated by 2 places : " + checkIfRotated(str1, str2));
		System.out.println("Is String 2 is rotated by 2 places : " + checkIfRotated(str3, str4));
		System.out.println("Is String 2 is rotated by 2 places : " + checkIfRotated(str5, str6));
		
		System.out.println(Long.valueOf("0000000001"));
		System.out.println(Long.valueOf("1"));
	}
}
