package com.interview.questions;

public class Palindrome {

	
	public static boolean checkIfPalindrome(int num) {
		
		
		int temp = reverse(num);
		if(temp == num)
			return true;
		
		return false;
	}
	
	public static int reverse(int num) {
		
		int reverseNum = 0;
		while(num != 0) {
			
			reverseNum = reverseNum * 10 + num % 10;
			num = num/10;
		}
		
		return reverseNum;
	}
	
	
	public static boolean checkPalindromeByComparison(int num) {
		
		
		int divisor = 1;
		
		
		while(num /divisor >= 10) {
			divisor *= 10;
		}
		
		
		while(num != 0) {
			int leadDigit = num/divisor;
			int lastDigit = num%10;
			
			if(leadDigit != lastDigit)
				return false;
			
			num = (num % divisor)/10;
			divisor /= 100;
		}
	
		return true;
	}
	
	
	// replace every occurrence of 0 with 5
	public static int replace0With5(int num) {
		
		if(num == 0)
			return 0;
		
		int lastDigit = num % 10;
		
		if(lastDigit == 0)
			lastDigit = 5;
		
		return replace0With5(num/10) * 10 + lastDigit;
	}
	
	public static void main(String[] args) {
		
		
		System.out.println(checkPalindromeByComparison(12321));
		
		System.out.println("New number : " + replace0With5(1020));
		
	}
}
