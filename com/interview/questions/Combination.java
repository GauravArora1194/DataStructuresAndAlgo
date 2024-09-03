package com.interview.questions;

public class Combination {

	
	static int counter = 0 ;
	public static void getCombination(boolean[] boxes, int totalQueen, int queenPlacedSoFar, String asf, int lastQueenPlacedInBox) {
		
		if(queenPlacedSoFar == totalQueen) {
			counter++;
			System.out.println(counter + "." + asf);
			return;
		}
		
		for (int b = lastQueenPlacedInBox + 1; b < boxes.length; b++) {
			if(boxes[b] == false) {
				
				boxes[b] = true;
				getCombination(boxes, totalQueen, queenPlacedSoFar+1, asf + " q" + (queenPlacedSoFar+1) + "b" + b, b);
				boxes[b] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		
		getCombination(new boolean[4], 2, 0, "",-1);
	}
	
}
