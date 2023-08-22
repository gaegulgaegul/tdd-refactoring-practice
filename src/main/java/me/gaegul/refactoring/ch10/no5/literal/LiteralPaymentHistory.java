package me.gaegul.refactoring.ch10.no5.literal;

/**
 * 결제 이력 리터럴 클래스
 */
public class LiteralPaymentHistory extends PaymentHistory {
	private int value;

	public LiteralPaymentHistory(final int value) {
		this.value = value;
	}

	@Override
	public int weeksDelinquentInLastYear() {
		return this.value;
	}
}
