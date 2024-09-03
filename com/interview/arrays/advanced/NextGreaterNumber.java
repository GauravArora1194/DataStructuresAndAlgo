package com.interview.arrays.advanced;

import java.util.Arrays;


public class NextGreaterNumber {

	// Given a number n, find the smallest number that has same set of digits as n
	// and is greater than n. If x is the greatest possible number with its set of
	// digits, then print “not possible”.

	
	public static int getNextGreaterNumber(int num) {
		
		// convert the number into string
		String str = String.valueOf(num);
		
		// convert the string into char array
		char[] chars = str.toCharArray();
		
		int i;
		
		// find the first digit from right which is smallest of all the digits to its right
		// for ex- in 218765, 1 is the smallest digit
	
		for(i = chars.length - 1; i > 0; i--) {
			
			if(chars[i] > chars[i-1]) // means first smallest digit found at position i - 1.
				break;
		}
		
		
		// if no such digit exists then, return number can not be formed (-1)
		if(i == 0) {
			return -1;
		}else {
			
			// then find the first smaller number in the right of the digit obtained above
			// that is greater than it and swap the two numbers.
			
			int x = chars[i-1]; // first smallest digit
			int min = i;       // first digit which is greater than the smallest digit
			
			for(int j = i + 1; j < chars.length; j++) {
				
				if(chars[j] > x && chars[j] < chars[min]) {
					// find the location of smallest digit which is greater then the x.
					min = j;
				}
			}
			
			
			// swap i - 1  && min
			char c = chars[i-1];
			chars[i-1] = chars[min];
			chars[min] = c;
			
			// then sort the remaining digits on the right, to get the first largest number 
			Arrays.sort(chars, i, chars.length);
			
			return Integer.valueOf(String.valueOf(chars));
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		int num = 341;
		System.out.println(getNextGreaterNumber(num));
		
		int n = 218765;
		System.out.println(getNextGreaterNumber(n));
		
		int n1 = 1234;
		System.out.println(getNextGreaterNumber(n1));
		
		int n2 = 4321;
		System.out.println(getNextGreaterNumber(n2));
		
		int n3 = 143;
		System.out.println(getNextGreaterNumber(n3));

	}
	
}
