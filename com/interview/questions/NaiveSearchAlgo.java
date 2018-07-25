package com.interview.questions;

public class NaiveSearchAlgo {

	
	//Naive pattern search algorithm(slide the pattern over text one by one)
	//Complexity -> O(n2)
	
	public static void search(String txt, String pat) {
		
		int count = 0 ;
		for(int i = 0 ; i <= txt.length() - pat.length() ; i++) {
			
			int j;
			for(j = 0 ; j < pat.length() ; j++) {
				
				if(txt.charAt(i+j) != pat.charAt(j))
					break;
			}
			
			if(j == pat.length()) {
				count++;
				System.out.println("Pattern found at index : " + i);
			}
			
		}
		
		
		if(count == 0)
			System.out.println("Pattern not found!");
		
		
	}
	
	
	public static void main(String[] args) {
		
		
		String txt = "AABAACAADAABAAABAA";
		String pat = "AABA";
		search(txt, pat);
	}
}
