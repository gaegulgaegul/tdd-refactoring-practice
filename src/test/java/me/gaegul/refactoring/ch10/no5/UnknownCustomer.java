package me.gaegul.refactoring.ch10.no5;

public class UnknownCustomer extends Customer {

	public static final String NAME = "미확인 고객";

	public UnknownCustomer() {
		super(NAME);
	}

	@Override
	public boolean isUnknown() {
		return true;
	}

	@Override
	public String name() {
		return "거주자";
	}

	@Override
	public BillingPlan billingPlan() {
		return BillingPlan.BASIC;
	}

	@Override
	public void setBillingPlan(final BillingPlan billingPlan) {
	}

	@Override
	public PaymentHistory paymentHistory() {
		return new NullPaymentHistory();
	}
}
