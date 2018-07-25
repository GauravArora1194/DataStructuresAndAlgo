package com.interview.questions;

import java.util.ArrayList;
import java.util.List;

public class KeyPadCombinations {

	
	static String[] codes = {"." ,"abc", "def", "ghi", "jkl", "mno", "pqr", "st" ,"uvwx" ,"yz"};

	public static List<String> getKeyCombinations(String str){
		
		
		if(str.length() == 0) {
			List<String> l = new ArrayList<>();
			l.add("");
			return l;
		}
		
		char ch =  str.charAt(0);
		
		List<String> list = getKeyCombinations(str.substring(1));
		
		List<String> result = new ArrayList<>();
		
		for(String s : list) {
			//String code = codes[Integer.valueOf(c)];
			String code = codes[ch-'0'];
			
			for(int i = 0; i < code.length(); i++) {
				result.add(code.charAt(i) + s);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		System.out.println(getKeyCombinations("179"));
	}
}
