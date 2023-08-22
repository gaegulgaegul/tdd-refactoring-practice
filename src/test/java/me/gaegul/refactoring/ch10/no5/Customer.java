package me.gaegul.refactoring.ch10.no5;

/**
 * 고객
 */
public class Customer {
	private final String name;			// 고객명
	private BillingPlan billingPlan;		// 요금제

	public Customer(final String name) {
		this.name = name;
		this.billingPlan = BillingPlan.BASIC;
	}

	public Customer(final String name, final BillingPlan billingPlan) {
		this.name = name;
		this.billingPlan = billingPlan;
	}

	public String name() {
		return this.name;
	}

	public BillingPlan billingPlan() {
		return this.billingPlan;
	}

	public PaymentHistory paymentHistory() {
		return new PaymentHistory();
	}

	public void setBillingPlan(final BillingPlan billingPlan) {
		this.billingPlan = billingPlan;
	}

	public boolean sameName(final String name) {
		return this.name.equals(name);
	}
}
