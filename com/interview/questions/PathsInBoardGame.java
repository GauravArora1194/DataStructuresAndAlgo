package com.interview.questions;

public class PathsInBoardGame {

	// prints paths from going from 1 to 10 in a board game (like ludo)
	
	
	static int counter = 0;
	public static void printPath(int src , int dest , String path ) {
	
		if(src == dest) {
			counter++;
			System.out.println(counter + "." + path);
			return;
		}
		
		if(src > dest) {
			return;
		}
		
		
		for(int dice = 1; dice <= 6; dice++) {
			
			int intermediate = src + dice;
			//here we can also use if(intermediate <= dest) condition
			printPath(intermediate, dest, path + dice);
		}
		
	}
	
	public static void main(String[] args) {
	
		printPath(0, 10, "");
	}
	
	
	
}
