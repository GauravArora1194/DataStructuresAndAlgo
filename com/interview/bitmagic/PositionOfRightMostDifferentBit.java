package com.interview.bitmagic;

public class PositionOfRightMostDifferentBit {

	// Given two numbers m and n. Find the position of rightmost different bit in
	// binary representation of numbers. It is guaranteed that such a bit exists.

	
	public static int findPosition(int m, int n) {
		
		int xorValue = m ^ n;
		
		 return (int)((Math.log10(xorValue & -xorValue)) / Math.log10(2)) + 1;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Bit at position " + findPosition(52, 4) + " is different");
	}
}
