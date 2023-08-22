package me.gaegul.refactoring.ch10.no5.literal;

import java.util.Map;

/**
 * 미확인 고객 리터럴 클래스
 */
public class LiteralUnknownCustomer extends Customer {
	private Map<String, String> literal;

	public LiteralUnknownCustomer(final Map<String, String> literal) {
		super(literal.get("name"));
		this.literal = literal;
	}

	@Override
	public boolean isUnknown() {
		return "true".equals(this.literal.getOrDefault("isUnknown", "false"));
	}

	@Override
	public BillingPlan billingPlan() {
		return BillingPlan.valueOf(this.literal.get("billingPlan"));
	}

	@Override
	public PaymentHistory paymentHistory() {
		return new LiteralPaymentHistory(Integer.valueOf(this.literal.get("paymentHistory")).intValue());
	}
}
