package com.interview.bitmagic;

public class ToggleBitsInGivenRange {

	/*
	 * Given a non-negative number n and two values l and r. The problem is to
	 * toggle the bits in the range l to r in the binary representation of n, i.e,
	 * to toggle bits from the rightmost lth bit to the rightmost rth bit. A toggle
	 * operation flips a bit 0 to 1 and a bit 1 to 0.
	 * 
	 * Constraint: 1 <= l <= r <= number of bits in the binary representation of n.
	 */
	
	
	public static int toggleBits(int n, int l, int r) {
		
		int num = ((1 << r) - 1) ^ ((1 << l-1) - 1);
		
		return n ^ num;
	}
	
	
	public static void main(String[] args) {
		
		
		System.out.println("Number after toggling bits in the range is : " + toggleBits(50, 2, 5));
		
	}

}
