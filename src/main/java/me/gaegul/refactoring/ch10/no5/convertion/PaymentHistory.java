package me.gaegul.refactoring.ch10.no5.convertion;

/**
 * 요금 이력
 */
public class PaymentHistory {
	private int weeksDelinquentInLastYear;

	public PaymentHistory() {
	}

	public PaymentHistory(int weeksDelinquentInLastYear) {
		this.weeksDelinquentInLastYear = weeksDelinquentInLastYear;
	}

	public int weeksDelinquentInLastYear() {
		return this.weeksDelinquentInLastYear;
	}

	public void setWeeksDelinquentInLastYear(final int weeksDelinquentInLastYear) {
		this.weeksDelinquentInLastYear = weeksDelinquentInLastYear;
	}
}
