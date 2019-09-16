package com.interview.recursion;

public class TowerOfHanoi {

	public static void main(String[] args) {

		printTowerOfHanoi(3, "A", "B", "C");

	}

	public static void printTowerOfHanoi(int disks, String source, String auxillary, String destination) {

		if (disks == 1) {
			System.out.println("Move disk " + disks + " from " + source + " to " + destination);
			return;
		}

		printTowerOfHanoi(disks - 1, source, destination, auxillary);
		System.out.println("Move disk " + disks + " from " + source + " to " + destination);
		printTowerOfHanoi(disks - 1, auxillary, source, destination);

	}

}
