package com.interview.questions;

public class SwapNibles {
	
	
	public static int swapNible(int num) {
		
		
		return ((num & 0x0F) << 4 | (num & 0xF0) >> 4);
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(swapNible(100));
		
		
	}

}
