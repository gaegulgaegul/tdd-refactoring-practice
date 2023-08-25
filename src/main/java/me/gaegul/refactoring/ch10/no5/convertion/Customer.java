package me.gaegul.refactoring.ch10.no5.convertion;

/**
 * 고객
 */
public class Customer {
	private String name;			// 고객명
	private BillingPlan billingPlan;		// 요금제
	private PaymentHistory paymentHistory;
	private boolean isUnknown;

	public Customer() {}

	public Customer(final String name, final BillingPlan billingPlan, final int weeksDelinquentInLastYear, final boolean isUnknown) {
		this.name = name;
		this.billingPlan = billingPlan;
		this.paymentHistory = new PaymentHistory(weeksDelinquentInLastYear);
		this.isUnknown = isUnknown;
	}

	public String name() {
		return this.name;
	}

	public BillingPlan billingPlan() {
		return this.billingPlan;
	}

	public PaymentHistory paymentHistory() {
		return this.paymentHistory;
	}

	public boolean isUnknown() {
		return this.isUnknown;
	}

	public void setBillingPlan(final BillingPlan billingPlan) {
		this.billingPlan = billingPlan;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setPaymentHistory(final PaymentHistory paymentHistory) {
		this.paymentHistory = paymentHistory;
	}

	public void setUnknown(final boolean unknown) {
		this.isUnknown = unknown;
	}

	public boolean sameName(final String name) {
		return this.name.equals(name);
	}
}
