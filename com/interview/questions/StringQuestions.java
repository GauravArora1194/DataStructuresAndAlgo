package com.interview.questions;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringQuestions {

	
	public static char getMaxOccuringChar(String str) {
		
		final int ASCII_SIZE = 256;
		int max =-1;
		char maxChar = ' ';
		int[] charCount = new int[ASCII_SIZE];
		
		for(int i = 0; i< str.length(); i++) {
			charCount[str.charAt(i)]++;
			if(max < charCount[str.charAt(i)]) {
				max = charCount[str.charAt(i)];
				maxChar = str.charAt(i);
			}
		}
		
		
		
		return maxChar;
	}
	
	public static char getFirstNonRepeatingChar(String str) {
		
		
		char[] chars = str.toCharArray();
		
		Map<Character, Integer> keyValuepair = new LinkedHashMap<>();
		
		for(char c : chars) {
			
			if(!keyValuepair.containsKey(c)) {
				keyValuepair.put(c, 1);
			}else {
				keyValuepair.put(c, keyValuepair.get(c)+1);
			}
		}
		
		for(Map.Entry<Character, Integer> entry : keyValuepair.entrySet()) {
			if(entry.getValue() == 1)
				return entry.getKey();
		}
		
		return chars[0];
	}
	
	
	public static String getSubString(String str, int start , int end) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = start; i < end; i++) {
			sb.append(str.charAt(i));
		}
		
		
		return sb.toString();
	}
	
	public static int  getSubStringIndex(String str, String subString) {
		
		
		int i = 0;
		int j = 0;
		
		for(; i < str.length(); ) {
			
			if(str.charAt(i) != subString.charAt(j)) {
				i++;
			}else {
				
				int curr_index = i;
				i++;
				j++;
				while(i < str.length() && j < subString.length()) {
					
					if(str.charAt(i) == subString.charAt(j)) {
						i++;
						j++;
					}else {
						break;
					}
				}
				
				if(j == subString.length()) {
					return curr_index;
				}
				i = curr_index + 1;
				j=0;
			}
			
			
		}
		
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		String str = "test sample";
		String str1 = "abccdbcefghbc";
		System.out.println(getSubStringIndex(str1, "cd"));
		System.out.println(getSubString(str, 1, 3));
		System.out.println(str1.replaceAll("bc", ""));
		char maxOccurChar = getMaxOccuringChar(str);
		System.out.println("Max char occurance : " + maxOccurChar);
		System.out.println("First Non repeating char : " + getFirstNonRepeatingChar("geeksforeeks"));
	}
	
	
}
