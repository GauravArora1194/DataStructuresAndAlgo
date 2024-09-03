package com.interview.strings;

public class String2IsRotationOfFirst {

	
	// checks if the second String is a rotated version of first String
	
	public static boolean checkIfRotatedVersion(String str1, String str2) {
		
		return (str1.length() == str2.length() && (str1 + str1).indexOf(str2) != -1 );
	}
	
	
	public static void main(String[] args) {
		
		String str1 = "ABCD";
		String str2 = "CDAB";
		
		String str3 = "CDBA";
		
		System.out.println("Is rotated version : " + checkIfRotatedVersion(str1, str2));
		System.out.println("Is rotated version : " + checkIfRotatedVersion(str1, str3));
		
	}
}
