package com.interview.strings;

public class MinimumInsertionsToFormPalindrome {
	
	// same approach as longest for palindrome substring problem
	
	// finds the minimum insertions needed for string of every size i.e. 0,1,2,3...str.length -1.
	public static int countMinInsertion(String str) {
		
		
		int[][] matrix = new int[str.length()][str.length()];
		
		//int max = 0;
		
		
		for(int diag = 0; diag < str.length(); diag++) {
			
			int si = 0;
			int ei = diag;
			
			while(ei < str.length()) {
				
				if(diag == 0) {
					matrix[si][ei] = 0;
				}else if(diag == 1 && str.charAt(si) != str.charAt(ei)) {
					matrix[si][ei] = 1;
				}else {
					if(str.charAt(si) == str.charAt(ei)) {
						matrix[si][ei] = matrix[si+1][ei-1];
					}else {
						matrix[si][ei] = 1 + matrix[si][ei-1];
					}
				}
				
				
				/*if(matrix[si][ei] > max) {
					max = matrix[si][ei];
				}*/
				
				si++;
				ei++;
			}
		}
		
		return matrix[0][str.length()-1];
	}
	
	
	public static void main(String[] args) {
		
		String str = "abcde";
		
		System.out.println("Minimum Insertions : " + countMinInsertion(str));
	}

}
