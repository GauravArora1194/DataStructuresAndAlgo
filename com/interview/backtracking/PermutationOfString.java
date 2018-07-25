package com.interview.backtracking;

public class PermutationOfString {

	
	static int count = 0;
	public static void permute(String str, int l, int r) {
		
		if(l == r) {
			System.out.println(++count + "." + str);
		}else {
			for(int i = l; i <=r; i++) {
				str = swap(str, l, i);
				permute(str, l+1, r);
				str = swap(str, l , i);
			}
		}
		
	}
	
	public static String swap(String str, int i, int j) {
		
		char[] charArr = str.toCharArray();
		char temp = charArr[i];
		charArr[i] = charArr[j];
		charArr[j] = temp;
		
		return String.valueOf(charArr);
		
	}
	
	public static void main(String[] args) {
		
		
		String str = "ABCD";
		permute(str, 0, str.length() -1);
	}
}
