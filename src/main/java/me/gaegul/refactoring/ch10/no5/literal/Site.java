package me.gaegul.refactoring.ch10.no5.literal;

import java.util.Map;

/**
 * 전력이 필요한 현장
 */
public class Site {
	private final Customer customer;	// 고객

	public Site(final String name) {
		this.customer = "미확인 고객".equals(name) ? createUnknownCustomer() : new Customer(name);
	}

	public Site(final String name, final BillingPlan billingPlan) {
		this.customer = new Customer(name, billingPlan);
	}

	public Customer customer() {
		return this.customer;
	}

	public LiteralUnknownCustomer createUnknownCustomer() {
		return new LiteralUnknownCustomer(
			Map.of(
				"isUnknown", "true",
				"name", "거주자",
				"billingPlan", BillingPlan.BASIC.name(),
				"paymentHistory", "0"
			)
		);
	}
}
