package com.interview.questions;

public class CoinChangeProblem {

	static int counter = 0;
	
	public static void coinChangeCombination(int[] denoms, int amt, int lastPaymentMadeIndex, String ansSofar) {
		
		if(amt == 0) {
			counter++;
			System.out.println(counter + "." + ansSofar);
			return;
		}
		
		for(int inst = lastPaymentMadeIndex; inst < denoms.length; inst++) {
			if(amt >= denoms[inst]) {
				
				coinChangeCombination(denoms, amt - denoms[inst], inst, ansSofar + denoms[inst]);
			}
		}
	}
	
	
	public static void coinChangePermutation(int[] denoms, int amt, int lastPaymentMadeIndex, String ansSofar) {
		
		if(amt == 0) {
			counter++;
			System.out.println(counter + "." + ansSofar);
			return;
		}
		
		for(int inst = 0; inst < denoms.length; inst++) {
			if(amt >= denoms[inst]) {
				
				coinChangePermutation(denoms, amt - denoms[inst], inst, ansSofar + denoms[inst]);
			}
		}
	}
	
	public static void main(String[] args) {
		
		coinChangeCombination(new int[] {2,3,5,6}, 10, 0, "");
		//coinChangePermutation(new int[] {2,3,5,6}, 10, 0, "");
	}
}
