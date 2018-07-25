package com.interview.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumberFromArray {

	//Arrange the given numbers to form  the biggest number
	
	public static void main(String[] args) {
		
		
		//int[] arr = {54,546,548,60};
		
		List<String> list = new ArrayList<>();
		
		list.add("54");
		list.add("546");
		list.add("548");
		list.add("60");
		
		Collections.sort(list, (x,y) -> {
			
			String X = (String) x;
			String Y = (String) y;
			String XY = X + Y;
			String YX = Y + X;
			
			System.out.println(" pair : "+ XY + " " + YX + " " + XY.compareTo(YX));
			return XY.compareTo(YX) > 0 ? -1 :1;
		});
		
		System.out.println(list);
	}
}
