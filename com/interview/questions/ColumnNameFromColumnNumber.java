package com.interview.questions;

public class ColumnNameFromColumnNumber {

	public static void main(String[] args) {
		
		char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		int number = 705;
		StringBuilder sb = new StringBuilder();
		while(number > 0) {
			
			int remainder = number%26;
			if(remainder == 0) {
				sb.append(alpha[25]);
				number = number/26 -1;
			}else {
				sb.append(alpha[remainder-1]);
				number = number/26;
			}
		}
		System.out.println(sb.reverse().toString());
	}
}
