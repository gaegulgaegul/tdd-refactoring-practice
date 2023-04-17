package me.gaegul.refactoring.ch06.split_phase;

public class Product {
	private final int basePrice;
	private final int discountThreshold;
	private final double discountRate;

	public Product(final int basePrice, final int discountThreshold, final double discountRate) {
		this.basePrice = basePrice;
		this.discountThreshold = discountThreshold;
		this.discountRate = discountRate;
	}

	public int basePrice() {
		return this.basePrice;
	}

	public int discountThreshold() {
		return this.discountThreshold;
	}

	public double discountRate() {
		return this.discountRate;
	}
}
