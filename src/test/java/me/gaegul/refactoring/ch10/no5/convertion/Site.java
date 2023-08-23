package me.gaegul.refactoring.ch10.no5.convertion;

/**
 * 전력이 필요한 현장
 */
public class Site {
	private String name;
	private String location;
	private Customer customer;	// 고객

	public Site() {
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setLocation(final String location) {
		this.location = location;
	}

	public void setCustomer(final Customer customer) {
		this.customer = customer;
	}

	public Customer customer() {
		return this.customer;
	}

	public String name() {
		return this.name;
	}

	public String location() {
		return this.location;
	}
}
