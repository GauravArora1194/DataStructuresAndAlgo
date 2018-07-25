package com.interview.questions;

public class TowerOfHanoi {

	
	public static void printTowerOfHanoi(int disks, char start, char mid, char end) {
		
		if(disks == 1) {
			System.out.println("Move disk 1 from rod " + start + " to rod " + end);
			return;
		}
		
		printTowerOfHanoi(disks-1, start, end, mid);
		System.out.println("Move disk "+ disks + " from rod " + start + " to rod " + end);
		printTowerOfHanoi(disks-1, mid, start, end);
		
	}
	
	public static void main(String[] args) {
		
		printTowerOfHanoi(2, 'A', 'B', 'C');
	}
}
