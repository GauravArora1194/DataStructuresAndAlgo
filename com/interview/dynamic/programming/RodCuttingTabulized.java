package com.interview.dynamic.programming;

public class RodCuttingTabulized {

	//how to cut the rod so  as to maximize the profit
	
	public static void rodCutTab(int[] arr) {
		
		int[] maxForCut = new int[arr.length];
		String[] cutSeq = new String[arr.length];
		
		maxForCut[0] = 0;
		maxForCut[1] = arr[1];
		cutSeq[0] = "";
		cutSeq[1] = "1 ";
		
		
		for(int i = 2; i < arr.length; i++) {
			
			maxForCut[i] = arr[i];
			cutSeq[i] = i + " ";
			
			
			int left = 1;
			int right = i-1;
			
			while(left <= right) {
				if(maxForCut[left] + maxForCut[right] > maxForCut[i]) {
					maxForCut[i] = maxForCut[left] + maxForCut[right];
					cutSeq[i] = cutSeq[left] + cutSeq[right];
				}
				
				left++;
				right--;
			}
		}
		
		System.out.println(maxForCut[arr.length - 1]);
		System.out.println(cutSeq[arr.length - 1]);
		
	}
	
	public static void main(String[] args) {
		
		
		int[] arr = {0,3,5,6,15,10,25,12,24};
		
		rodCutTab(arr);
	}
}
