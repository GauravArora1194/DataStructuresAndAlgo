package com.interview.sortings;

public class SortCharacterArray {
	
	private static int MAX_CHAR_LENGTH = 256;
	
	public static char[] sort(char[] chars) {
		
		
		int[] characters = new int[MAX_CHAR_LENGTH];
		
		for(int i = 0; i < chars.length; i++) {
			
			characters[chars[i]]++;
		}
		
		int j = 0;
		for(int i = 0; i < MAX_CHAR_LENGTH; i++) {
			
			if(characters[i] > 0) {
				
				int count = characters[i];
				
				while(count != 0) {
					chars[j] = (char) i;
					j++;
					count--;
				}
				
			}
			
		}
		
		return chars;
		
	}
	
	public static void main(String[] args) {
		
		char[] chars = {'d','e','c','b','a','z','y','b','a'};
		
		char[] newChars = sort(chars);
		
		System.out.println(newChars);
	}

}
