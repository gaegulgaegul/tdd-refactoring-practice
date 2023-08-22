package me.gaegul.refactoring.ch10.no5;

/**
 * 고객
 */
public class Customer {
	private final String name;			// 고객명
	private BillingPlan billingPlan;		// 요금제
	private PaymentHistory paymentHistory;

	public Customer(final String name) {
		this.name = name;
		this.billingPlan = BillingPlan.BASIC;
		this.paymentHistory = new PaymentHistory();
	}

	public Customer(final String name, final BillingPlan billingPlan) {
		this.name = name;
		this.billingPlan = billingPlan;
		this.paymentHistory = new PaymentHistory();
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

	public void setBillingPlan(final BillingPlan billingPlan) {
		this.billingPlan = billingPlan;
	}

	public boolean sameName(final String name) {
		return this.name.equals(name);
	}
}
