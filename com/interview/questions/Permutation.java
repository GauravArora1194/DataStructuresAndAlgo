package com.interview.questions;

public class Permutation {

	
	static int counter = 0 ;
	public static void getPermutation(boolean[] boxes, int totalQueen, int queenPlacedSoFar, String asf) {
		
		if(queenPlacedSoFar == totalQueen) {
			counter++;
			System.out.println(counter + "." + asf);
			return;
		}
		
		for (int b = 0; b < boxes.length; b++) {
			if(boxes[b] == false) {
				
				boxes[b] = true;
				getPermutation(boxes, totalQueen, queenPlacedSoFar+1, asf + " q" + (queenPlacedSoFar+1) + "b" + b);
				boxes[b] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		
		getPermutation(new boolean[4], 2, 0, "");
	}
}
