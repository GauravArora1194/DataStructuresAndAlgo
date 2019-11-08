package com.interview.design.patterns.builder;

import com.interview.design.patterns.builder.LunchOrder.Builder;

public class LunchOrderDemo {

	public static void main(String[] args) {

		Builder builder = new Builder();

		builder.getBread("bread").getCondiments("condiments").getDressing("dressing").getMeat("meat");

		LunchOrder order = builder.build();

		System.out.println(order.getBread());
		System.out.println(order.getCondiments());
		System.out.println(order.getDressing());
		System.out.println(order.getMeat());

	}

}
