package me.gaegul.refactoring.ch06.split_phase;

public class ShippingMethod {
	private final int discountThreshold;
	private final int discountFee;
	private final int feePerCase;

	public ShippingMethod(final int discountThreshold, final int discountFee, final int feePerCase) {
		this.discountThreshold = discountThreshold;
		this.discountFee = discountFee;
		this.feePerCase = feePerCase;
	}

	public int discountThreshold() {
		return this.discountThreshold;
	}

	public int discountedFee() {
		return this.discountFee;
	}

	public int feePerCase() {
		return this.feePerCase;
	}
}
