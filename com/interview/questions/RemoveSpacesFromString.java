package com.interview.questions;

public class RemoveSpacesFromString {

	
	public static String removeSpace(String str) {
	
		String newString = "";
		for (int i=0; i<str.length(); i++) {
			
			if((str.charAt(i)) != ' ') {
				newString = newString + str.charAt(i);
			}
			
		}
		
		return newString;
	}
	
	public static void main(String[] args) {
		
		String str = "      g  eeks   for ge  eeks  ";
		
		System.out.println("Original String : " + str );
		String spaceRemovedString = removeSpace(str);
		
		System.out.println("New String : " + spaceRemovedString);
		
	}
	
}
