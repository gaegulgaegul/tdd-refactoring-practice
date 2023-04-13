package me.gaegul.refactoring.ch06.combine_functions_into_class;

public class Reading {
	private final String customer;
	private final int quantity;
	private final int month;
	private final int year;

	public Reading(final String customer, final int quantity, final int month, final int year) {
		this.customer = customer;
		this.month = month;
		this.year = year;
		this.quantity = quantity;
	}

	public Reading(Reading aReading) {
		this(aReading.customer, aReading.quantity, aReading.month, aReading.year);
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

	int baseCharge() {
		return baseRate(month(), year()) * quantity();
	}

	public int taxableCharge(Reading aReading) {
		return Math.max(0, aReading.baseCharge() - taxThreshold(aReading.year()));
	}

	private int taxThreshold(int year) {
		return 0;
	}

	private int baseRate(int month, int year) {
		return 0;
	}
}
