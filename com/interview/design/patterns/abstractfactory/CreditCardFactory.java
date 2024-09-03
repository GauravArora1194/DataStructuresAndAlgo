package com.interview.design.patterns.abstractfactory;

// AbstractFactory
public abstract class CreditCardFactory {

	public static CreditCardFactory getCreditCardFactory(int creditCardScore) {

		if (creditCardScore > 650) {

			return new AmexFactory();
		} else {

			return new VisaFactory();
		}
	}

	public abstract CreditCard getCreditCard(CardType cardType);

	public abstract Validator getValidator(CardType cardType);

}
