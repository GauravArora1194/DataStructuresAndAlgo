package com.interview.design.patterns.creational;


public class SingletonPattern {

	
	public static void main(String[] args) {
		
		
		Runtime firstInstance = Runtime.getRuntime();
		
		Runtime secondInstance = Runtime.getRuntime();
		
		System.out.println(firstInstance);
		System.out.println(secondInstance);
		
		if(firstInstance == secondInstance) {
			System.out.println("they are equal");
		}
		
	}
	
}
