package com.interview.questions;

public class SpareNumber {

	
	//A number is a sparse number if there is no consecutive ones in it's binary representation.
	//eg. 5->101 is a sparse number and 6->110 is not.
	         
	public static boolean isSparse(int num) { 
		
		int numAndValue = num & num >> 1;
		
		if(numAndValue == 0)
			return true;
		
		return false;
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		int num = 11;
		
		System.out.println("Is number a Sparse number : " + isSparse(num));
		
		System.out.println((int) 'a');
		System.out.println('a');
		
		
	}
}
