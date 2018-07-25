package com.interview.strings;

public class RecursivelyRemoveAllDuplicates {

	//Recursively remove adjacent duplicate characters from string
	
	public static String removeAdjacentDuplicate(String str) {
		
		
		for(int i = 0; i+1 < str.length(); i++) {
			
			
				if(str.charAt(i) == str.charAt(i+1)) {
					str = str.substring(0, i) + str.substring(i+2);
				    i= i-2;
					
				}
				
				
			
			
		}
		
		return str;
		
	}
	
	
	public static String remove(String str) {
		
		char[] chars = new char[str.length()];
		int top = 0 ;
		
		char lastRemoved = '\u0000';
		
		chars[top] = str.charAt(0);
		
		
		for(int i = 1; i < str.length(); i++) {
			
			if( top >= 0 && str.charAt(i) == chars[top]) {
				
				lastRemoved = chars[top];
				chars[top] = '\u0000';
				top--;
			}else if (top < 0 && str.charAt(i) == lastRemoved) {
				
			}
			else if( top < 0 || str.charAt(i) != chars[top] && str.charAt(i) != lastRemoved) {
				
				chars[++top] = str.charAt(i);
			}
		}
		
		return String.valueOf(chars);
		
	}
	
	public static void main(String[] args) {
		
		String str6 = "azxxzy";
		String str = "aaa";
		String str1 = "geeksforgeeg";
		String str2 = "acaaabbbacdddd";
		String str3 = "caaabbbaacdddd";
		String str4 = "qpaaaaadaaaaadprq";
		
		//System.out.println(removeAdjacentDuplicate(str));
		//System.out.println(removeAdjacentDuplicate(str1));
		//System.out.println(removeAdjacentDuplicate(str2));
		
		System.out.println(remove(str6));
		System.out.println(remove(str));
		System.out.println(remove(str1));
		System.out.println(remove(str2));
		System.out.println(remove(str3));
		System.out.println(remove(str4));
		
	}
	
	
}

