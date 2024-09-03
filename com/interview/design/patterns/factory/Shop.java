package com.interview.design.patterns.factory;

public class Shop extends Website {
	
	public Shop() {
		super();
	}

	@Override
	public void createWebsite() {

		pages.add(new CartPage());
		pages.add(new ItemPage());
		pages.add(new SearchPage());
	}

}
