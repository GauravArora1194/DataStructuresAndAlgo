package com.interview.design.patterns.builder;

public class LunchOrder {

	public static class Builder {

		private String bread;
		private String condiments;
		private String dressing;
		private String meat;

		public Builder() {

		}

		public LunchOrder build() {
			return new LunchOrder(this);
		}

		public Builder getBread(String bread) {
			this.bread = bread;
			return this;
		}

		public Builder getCondiments(String condiments) {
			this.condiments = condiments;
			return this;
		}

		public Builder getDressing(String dressing) {
			this.dressing = dressing;
			return this;
		}

		public Builder getMeat(String meat) {
			this.meat = meat;
			return this;
		}
	}

	private final String bread;
	private final String condiments;
	private final String dressing;
	private final String meat;

	public LunchOrder(Builder builder) {

		this.bread = builder.bread;
		this.condiments = builder.condiments;
		this.dressing = builder.dressing;
		this.meat = builder.meat;
	}

	public String getBread() {
		return bread;
	}

	public String getCondiments() {
		return condiments;
	}

	public String getDressing() {
		return dressing;
	}

	public String getMeat() {
		return meat;
	}
}
