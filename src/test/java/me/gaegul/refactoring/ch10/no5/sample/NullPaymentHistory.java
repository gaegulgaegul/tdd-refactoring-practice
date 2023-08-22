package me.gaegul.refactoring.ch10.no5;

/**
 * 결재 이력 예외 방지
 */
public class NullPaymentHistory extends PaymentHistory {

	@Override
	public int weeksDelinquentInLastYear() {
		return 0;
	}
}
