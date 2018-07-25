package com.interview.bitmagic;

public class CheckIfKthBitIsSet {
	
	// checks if the Kth bit is set or not in binary representation of a number.
	
	
	public static boolean checkIfSet(int num, int k) {
		
		int n = 1 << k-1;
		
		return (num & n )!= 0 ? true : false;
	}

	public static void main(String[] args) {
		
		int k = 3 ;
		int num = 2;
		
		System.out.println("Is " + k +"th bit set : " + checkIfSet(num, k));
	}
}
