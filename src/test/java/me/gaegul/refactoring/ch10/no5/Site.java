package me.gaegul.refactoring.ch10.no5;

/**
 * 전력이 필요한 현장
 */
public class Site {
	private final Customer customer;	// 고객

	public Site(final String name) {
		this.customer = UnknownCustomer.NAME.equals(name) ? new UnknownCustomer() : new Customer(name);
	}

	public Customer customer() {
		return this.customer;
	}
}
