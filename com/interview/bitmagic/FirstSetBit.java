package com.interview.bitmagic;

public class FirstSetBit {

	// given a number in binary form containing only one 1 and remaining bits 0.
	// find the position of first set bit.
	
	// ex- 100 -> 3  (110 001+1 - 010)   (100 011+1 - 100)
	public static int findPosition(int n) {
		
		int i = n & -n; // here -n is the 2's complement of n.
		
		if(i != n)
			return -1;
		
		int pos = 0;
		
		while(n != 0) {
			
			n = n >> 1;
			pos++;
		}
		
		return pos;
		
	}
	
	 public static int getFirstSetBitPos(int n)
	    {
	       return (int)((Math.log10(n & -n)) / Math.log10(2)) + 1;
	    }
	
	
	public static void main(String[] args) {
		
		System.out.println("Set bit position is : " + findPosition(128));
	}
}
