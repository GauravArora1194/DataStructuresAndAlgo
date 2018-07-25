package com.interview.strings;

public class KMPSearchAlgo {

	// computes the length of longest proper prefix which is also a suffix
	
	public static int[] computeLPS(String str) {
		
		char[] chars = str.toCharArray();
		int[] lps = new int[chars.length];
		
		lps[0] = 0;
		int j = 0;
		
		for(int i = 1; i < chars.length;) {
			
			if(chars[i] == chars[j]) {
				
				lps[i] = j + 1;
				i++;
				j++;
			}else {
				
				
				if(j == 0 && chars[j] != chars[i]) {
					lps[i] = 0;
					i++;
				}else {
					j = lps[j-1];
				}
			}
		}
		
		
		return lps;
	}
	
	
	public static void KMPSerarch(String text, String patt) {
		
		int m = patt.length();
		int n = text.length();
		
		int i = 0; 
		int j = 0;
		int count = 0;
		
		int[] lps = computeLPS(patt);
		
		while(i < n) {
			
			
			
			if(text.charAt(i) == patt.charAt(j)) {
				
				i++;
				j++;
			}
			
			
			if(j == m) {
				count++;
				System.out.println("Pattern found at index : " + (i - j));
				j = lps[j-1];
			}
			else if(i < n && text.charAt(i) != patt.charAt(j)) {
				
				if(j != 0)
					j = lps[j-1];
				else
					i = i + 1; 
				
			}
			
			
		}
		
		if(count == 0)
			System.out.println("Pattern not found!");
	}
	
	public static void main(String[] args) {
		
		String text = "AABAACAADAABAABA";
		String patt = "AABA";
		
		/*int[] lps = computeLPS(str);
		
		for(int i : lps) {
			System.out.print(i + " ");
		}*/
		
		KMPSerarch(text, patt);
	}
}
