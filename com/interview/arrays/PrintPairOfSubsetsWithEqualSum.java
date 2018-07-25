package com.interview.arrays;

import java.util.ArrayList;

public class PrintPairOfSubsetsWithEqualSum {
	
	
	public static void pes(int[] arr, int vidx, int setsum1, String set1, int setsum2, String set2) {
		
		if(vidx == arr.length) {
			
			if(setsum1 == setsum2) {
				System.out.println(set1 + " . & " + set2 + ".");
			}
			return;
		}
		
		pes(arr, vidx +1 , setsum1 + arr[vidx], set1 + " " + arr[vidx], setsum2, set2);
		pes(arr, vidx+1, setsum1, set1, setsum2 + arr[vidx], set2 + " " + arr[vidx]);
	}
	
	
	public static void pes1(int[] arr, int vidx, int setsum1, ArrayList<Integer> set1, int setsum2, ArrayList<Integer> set2) {
		
		if(vidx == arr.length) {
			
			if(setsum1 == setsum2) {
				System.out.println(set1 + " . & " + set2 + ".");
			}
			return;
		}
		
		
		set1.add(arr[vidx]);
		pes1(arr, vidx +1 , setsum1 + arr[vidx], set1, setsum2, set2);
		set1.remove(set1.size()-1);
		
		set2.add(arr[vidx]);
		pes1(arr, vidx+1, setsum1, set1, setsum2 + arr[vidx], set2 );
		set2.remove(set2.size()-1);
	}
	
	public static void main(String[] args) {
		
		int[] arr = {10,20,30,40,50,60,70};
		
		//pes(arr, 0, 0, "", 0, "");
		pes1(arr, 0, 0, new ArrayList<>(), 0, new ArrayList<>());
	}

}
