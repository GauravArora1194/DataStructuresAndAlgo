package com.interview.questions;

import java.util.ArrayList;
import java.util.List;

public class SubSequencesInString {

	
	public static List<String> getSubSequence(String str){
		
		if(str.length() == 0) {
			
			List<String> l = new ArrayList<>();
			l.add("");
			return l;
		}
		
		char c = str.charAt(0);
		String subStr = str.substring(1);
		
		List<String> list = getSubSequence(subStr);
		
		List<String> result = new ArrayList<>();
		
		for(String s : list) {
			result.add(s);
			result.add(c + s);
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		
		
		String str = "abc";
		System.out.println(getSubSequence(str));
	}
}
