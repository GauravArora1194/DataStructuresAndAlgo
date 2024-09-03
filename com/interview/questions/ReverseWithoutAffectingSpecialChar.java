package com.interview.questions;

public class ReverseWithoutAffectingSpecialChar {

	
	//reverse a string without affecting special characters
	public static String reverseString(String str) {
		
		int start = 0;
		int end = str.length() - 1;
		char[] chars = str.toCharArray();
		//boolean s1 = false;
		//boolean s2 = false;
		while(start < end ) {
			
			//s1 = isSpecialChar(chars[start]);
			//s2 = isSpecialChar(chars[end]);
			
			while(start < end && isSpecialChar(chars[start])) {
				start++;
			}
			
			while(start < end && isSpecialChar(chars[end])) {
				end--;
			}
			
			/*if(s1) 
				start++;
			if(s2) 
				end--;*/
			if(start < end) {
				
				char c =chars[end];
				chars[end] = chars[start];
				chars[start] = c;
				start++;
				end--;
			}
			
		}
		
		
		return new String(chars);
	}
	
	public static boolean isSpecialChar(char c) {
		
		if(('A' <= c && c<= 'Z') || ('a' <= c && c<= 'z')) {
			return false;
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		
		String str = "Ab,c,de!$Z"; //a,b$c
		System.out.println("Original String : "+ str);
		String newString = reverseString(str);
		System.out.println("New String : " + newString);
		
	}
}
