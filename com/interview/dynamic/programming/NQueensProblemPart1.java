package com.interview.dynamic.programming;

public class NQueensProblemPart1 {
	
	static int counter = 0;
	
	public static void nQueens(boolean[][] chess , int qpsf, String asf, int lqpb) {
		
		if(qpsf == chess.length) {
			counter++;
			
			if(theChessBoardIsValid(chess) == true) {
				
				System.out.println(counter + ". " + asf);
			}
			return;
		}
		
		for(int b = lqpb + 1; b < chess.length*chess.length; b++) {
			
			int row = b/chess.length;
			int col = b%chess.length;
			
			if(chess[row][col] == false) {
				
				chess[row][col] = true;
				nQueens(chess, qpsf+1, asf + "q" + (qpsf + 1) + "b" + b + " ", b);
				chess[row][col] = false;
			}
		}
	}
	
	
	private static boolean theChessBoardIsValid(boolean[][] chess) {
		
		for(int row = 0; row < chess.length; row++) {
			for(int col = 0; col < chess[row].length; col++) {
				if(chess[row][col] == true) {
					if(theQueenIsSafe(chess, row, col) == false) {
						return false;
					}
				}
			}
		}
		
		return true;
	}


	private static boolean theQueenIsSafe(boolean[][] chess, int row, int col) {
		int[][] dirs = {
				{0,-1}, //NORTH
				{+1,-1}, //NORTH EAST
				{+1,0}, //EAST
				{+1,+1}, //SOUTH EAST
				{0,+1}, //SOUTH
				{-1,+1}, //SOUTH WEST
				{-1,0}, //WEST
				{-1,-1} //NORTH WEST
				
		};
		
		
		for(int di = 0; di < dirs.length; di++) {
			for(int dist = 1; true; dist++) {
				int eqcol = col + dist * dirs[di][0];
				int eqrow = row + dist * dirs[di][1];
				
				
				if(eqrow < 0 || eqcol < 0 || eqcol >=chess[0].length || eqrow >=chess.length) {
					break;
				}
				
				if(chess[eqrow][eqcol] == true) {
					return false;
				}
			}
		}
		
		return true;
	}


	public static void main(String[] args) {
		
		boolean[][] chess = new boolean[4][4];
		
		nQueens(chess, 0, "", -1);
		
	}

}
