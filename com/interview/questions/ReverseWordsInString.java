package com.interview.questions;

public class ReverseWordsInString {

	
	public static String reverse(String str) {
		
		return new StringBuilder(str).reverse().toString();
	}
	
	
	public static void main(String[] args) {
		
		
		StringBuilder sb = new StringBuilder();
		String str = "geeks quiz practice code";
		String[] strArray = str.split(" ");
		
		/*for(String s : strArray) {
			s = reverse(s);
			sb.append(s + " ");
			
		}*/
		
		//Another approach
		
		int start = 0;
		int end = strArray.length -1;
		String temp = "";
		while(start < end) {
			
			temp = strArray[start];
			strArray[start] =  strArray[end];
			strArray[end] = temp;
			end--;
			start++;
		}
		
		for(String s : strArray) {
		sb.append(s + " ");
		
		}
		
		System.out.println(String.join(" ", strArray));
		
		System.out.println(sb.toString());
		
		System.out.println((sb.toString()).trim());
		
	}
}
