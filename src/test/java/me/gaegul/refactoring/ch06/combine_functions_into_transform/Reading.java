package me.gaegul.refactoring.ch06.combine_functions_into_transform;

public class Reading implements Cloneable {
	private final String customer;
	private final int quantity;
	private final int month;
	private final int year;
	private int baseCharge;

	public Reading(final String customer, final int quantity, final int month, final int year) {
		this.customer = customer;
		this.month = month;
		this.year = year;
		this.quantity = quantity;
	}

	@Override
	protected Reading clone() {
		return new Reading(this.customer, this.quantity, this.month, this.year);
	}

	public int month() {
		return this.month;
	}

	public int year() {
		return this.year;
	}

	public int quantity() {
		return this.quantity;
	}

	public void setBaseCharge(int baseCharge) {
		this.baseCharge = baseCharge;
	}

	public int getBaseCharge() {
		return this.baseCharge;
	}
}
