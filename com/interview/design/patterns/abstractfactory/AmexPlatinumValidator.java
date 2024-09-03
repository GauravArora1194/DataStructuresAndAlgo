package com.interview.design.patterns.abstractfactory;

public class AmexPlatinumValidator implements Validator {

	@Override
	public boolean isValid(CreditCard creditCard) {

		return false;
	}

}
