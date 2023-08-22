package me.gaegul.refactoring.ch10.no5;

public class NullPaymentHistory extends PaymentHistory {

	@Override
	public int weeksDelinquentInLastYear() {
		return 0;
	}
}
