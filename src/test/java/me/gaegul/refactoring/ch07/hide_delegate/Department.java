package me.gaegul.refactoring.ch07.hide_delegate;

public class Department {
	private String chargeCode;
	private String manager;


	public String chargeCode() {
		return this.chargeCode;
	}

	public void setChargeCode(final String chargeCode) {
		this.chargeCode = chargeCode;
	}

	public String manager() {
		return this.manager;
	}

	public void setManager(final String manager) {
		this.manager = manager;
	}
}
