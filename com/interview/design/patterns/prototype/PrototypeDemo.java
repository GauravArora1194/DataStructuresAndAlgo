package com.interview.design.patterns.prototype;

public class PrototypeDemo {

	public static void main(String[] args) {

		Registry registry = new Registry();

		Movie movie = (Movie) registry.createItem("Movie");
		movie.setTitle("Creational pattern in Java!");

		System.out.println(movie);
		System.out.println(movie.getRuntime());
		System.out.println(movie.getTitle());
		System.out.println(movie.getUrl());
		System.out.println(movie.getImage());

		Movie anotherMovie = (Movie) registry.createItem("Movie");
		anotherMovie.setTitle("Gang of Four");

		System.out.println(anotherMovie);
		System.out.println(anotherMovie.getRuntime());
		System.out.println(anotherMovie.getTitle());
		System.out.println(anotherMovie.getUrl());
		System.out.println(anotherMovie.getImage());
		
		System.out.println(movie.getTitle());

	}

}
