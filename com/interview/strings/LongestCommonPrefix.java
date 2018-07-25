package com.interview.strings;

public class LongestCommonPrefix {

	// Given a set of string , find the longest common prefix
	
	// Methods - 

	// 1. using iterative method - find longest prefix of first two strings than
	// find the longest prefix of result and next string and continue till end.
	// (Word by Word Matching)
	
	
	public static String commonPrefixIterative(String[] strArr) {
		
		String result = strArr[0];
		
		for(int i = 1 ; i < strArr.length; i++ ) {
			
			result = commonPrefix(result , strArr[i]);
		}
		
		
		return result;
	}

	private static String commonPrefix(String str1, String str2) {
		
		String prefix = "";
		
		for(int i = 0, j = 0; i < str1.length() && j < str2.length(); i++,j++ ) {
			
			if(str1.charAt(i) != str2.charAt(j))
				break;
			
			prefix = prefix + str1.charAt(i);
			
		}
		
		return prefix;
	}
	
	
	// 2. Character by Character Matching
	// here we compare each characters of word simultaneously and continue until a mismatch occur.
	
	public static int getMinLength(String[] strArr) {
		
		int minLength = strArr[0].length();
		
		for(int i = 1 ; i < strArr.length; i++) {
			
			if(strArr[i].length() < minLength)
				minLength = strArr[i].length();
		}
		
		return minLength;
		
	}
	
	public static String commonPrefixByCharacterMatching(String[] strArr) {
		
		int minLength = getMinLength(strArr);
		
		String result = "";
		
		for(int i = 0 ; i < minLength; i++) {
			
			char c = strArr[0].charAt(i);
			
			for(int j = 1 ; j < strArr.length; j++) {
				
				if(strArr[j].charAt(i) != c)
					return result;
			}
			
			result = result + c;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		String[] strArr = {"geeksforgeeks", "geeks", "geek", "geezer"};
		
		String[] strArr1 = {"apple", "ape", "april"};
		
		System.out.println("-------------WORD BY WORD MATCHING-----------------");
		
		System.out.println("Longest Common Prefix is : " + commonPrefixIterative(strArr));
		
		System.out.println("Longest Common Prefix is : " + commonPrefixIterative(strArr1));
		
		System.out.println("\n-------------CHARACTER BY CHARACTER MATCHING------------");
		
		System.out.println("Longest Common Prefix is : " + commonPrefixByCharacterMatching(strArr));
		
		System.out.println("Longest Common Prefix is : " + commonPrefixByCharacterMatching(strArr1));
	}
}
