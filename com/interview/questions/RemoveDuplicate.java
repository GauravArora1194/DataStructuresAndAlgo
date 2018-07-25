package com.interview.questions;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicate {

	
	public static String removeDuplicate(String str) {
		
		char[] chars = str.toCharArray();
		
		Set<Character> charSet = new LinkedHashSet<>();
		
		for(Character c : chars) {
			charSet.add(c);
		}
		 
		StringBuilder sb = new StringBuilder();
		for(Character c : charSet) {
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static String removeDuplicate1(String str) {
		
		char[] chars = str.toCharArray();
		
		String result = ""; 
		
		Set<Character> charSet = new HashSet<>();
		
		for(Character c : chars) {
			if(!charSet.contains(c)) {
				
				charSet.add(c);
				result = result + c;
			}
				
		}
		 
		
		return result;
	}
	
	public static void main(String[] args) {
		
		
		String str = "geeksforgeeks";
		System.out.println("Original String : "+ str);
		String newString = removeDuplicate(str);
		System.out.println("New String : " + newString);
		
		String newString1 = removeDuplicate1(str);
		System.out.println("New String with second method : " + newString1);
		
	}
}
