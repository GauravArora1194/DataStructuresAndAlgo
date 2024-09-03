package com.interview.expedia;

// Given coordinates of a source point (x1, y1) determine if it is possible to reach the destination point (x2, y2). 
// From any point (x, y) there only two types of valid movements:
// (x, x + y) and (x + y, y). Return a boolean true if it is possible else return false.
public class PathBetweenTwoPoints {
	
	
	public static boolean checkIfPathExist(int sr, int sc, int dr, int dc) {
		
		if(sr > dr || sc > dc)
			return false;
		
		if(sr == dr && sc == dc)
			return true;
		
		
		return checkIfPathExist(sr, sc+sr, dr, dc) || checkIfPathExist(sr+sc, sc, dr, dc);
		
		// instead of above return we can also use below approach;
		
		/*if(sc + sr <= dc ) {
			checkIfPathExist(sr, sc+sr, dr, dc);
		}
		
		if(sr + sc <= dr ) {
			checkIfPathExist(sr+sc, sc, dr, dc);
		}
		
		if(sr > dr || sc > dc)
			return false;
		else
			return true;
		*/
	}
	
	
	public static void main(String[] args) {
		
		int sr = 2;
		int sc = 10;
		int dr = 26;
		int dc = 12;
		
		int sr1 = 20;
		int sc1 = 10;
		int dr1 = 6;
		int dc1 = 12;
		
		System.out.println("Path exist : " + checkIfPathExist(sr, sc, dr, dc));
		System.out.println("Path exist : " + checkIfPathExist(sr1, sc1, dr1, dc1));
	}

}
