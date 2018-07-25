package com.interview.questions;

public class FlipBitsToConvertNumbers {

	// 1. do XOR of a and b.
	// 2. count number of set bits in the above result.
	
	public static void main(String[] args) {
		
		int a = 10, b= 20;
		
		int temp = a^b;
		int count = 0;
		
		while(temp != 0) {
			temp = temp & temp-1;
			count++;
			
		}
		
		System.out.println(count);
		
		
		//swap numbers using XOR
		a= a^b;
		b=a^b;
		a=a^b;
		System.out.println(a + " " + b);
	}
	
	
}
