package com.interview.questions;

public class PathsInMaze {

	
	public static void byProactiveWay(int sr, int sc, int dr, int dc, String path) {
		
		if(sr == dr && sc == dc) {
			System.out.println(path);
			return;
		}
		
		//Horizontal call
		if(sc+1 <= dc ) {
			
			byProactiveWay(sr, sc+1, dr, dc, path + "H");
		}
		
		//Vertical call
		if(sr+1 <= dr) {
			byProactiveWay(sr+1, sc, dr, dc, path + "V");
		}
		
		
		
	}
	
	
	
	public static void byreactiveWay(int sr, int sc, int dr, int dc, String path) {
		
		
		if(sr == dr && sc == dc) {
			System.out.println(path);
			return;
		}
		
		if(sr > dr || sc > dc) {
			return;
		}
		
		//Horizontal call
		byProactiveWay(sr, sc+1, dr, dc, path + "H");
		
		//Vertical call
		byProactiveWay(sr+1, sc, dr, dc, path + "V");
		
	}
	
	
	
	public static void diagonalAllowed(int sr, int sc, int dr, int dc, String path) {
		
		
		if(sr == dr && sc == dc) {
			System.out.println(path);
			return;
		}
		
		if(sr > dr || sc > dc) {
			return;
		}
		
		//Horizontal call
		diagonalAllowed(sr, sc+1, dr, dc, path + "H");
		
		//Vertical call
		diagonalAllowed(sr+1, sc, dr, dc, path + "V");
		
		//Diagonal Call
		diagonalAllowed(sr+1, sc+1, dr, dc, path + "D");
		
	}
	
	public static void main(String[] args) {
		
		/*byProactiveWay(0, 0, 2, 2, "");
		System.out.println("\n\n");
		byreactiveWay(0, 0, 2, 2, "");
		System.out.println("\n\n"); */
		diagonalAllowed(0, 0, 2, 2, "");
		
	}
	
}
