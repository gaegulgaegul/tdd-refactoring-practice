package me.gaegul.refactoring.ch06.split_phase;

public class Payment {
	public double priceOrder(final Product product, final int quantity, final ShippingMethod shippingMethod) {
		int basePrice = product.basePrice() * quantity;
		double discount = Math.max(quantity - product.discountThreshold(), 0)
			* product.basePrice() * product.discountRate();
		int shippingPerCase = (basePrice > shippingMethod.discountThreshold())
			? shippingMethod.discountedFee() : shippingMethod.feePerCase();
		int shippingCost = quantity * shippingPerCase;
		double price = basePrice - discount + shippingCost;
		return price;
	}
}
