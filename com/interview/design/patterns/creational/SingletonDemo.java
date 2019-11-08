package com.interview.design.patterns.creational;

public class SingletonDemo {

	// To make it thread safe we are using volatile
	private static volatile SingletonDemo instance = null;

	private SingletonDemo() {

		// To prevent reflection

		if (instance != null) {
			throw new RuntimeException("Use getInstance() method to create instance");
		}
	}

	public static SingletonDemo getInstance() {

		if (instance == null) {

			synchronized (SingletonDemo.class) {

				if (instance == null) {

					instance = new SingletonDemo();
				}
			}

		}

		return instance;
	}

}
