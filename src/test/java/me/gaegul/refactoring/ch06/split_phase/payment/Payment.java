package me.gaegul.refactoring.ch06.split_phase.payment;

public class Payment {
	public double priceOrder(final Product product, final int quantity, final ShippingMethod shippingMethod) {
		// 결제 금액 중 상품 가격을 계산한다.
		final PriceData priceData = calculatePricingData(product, quantity);
		// 배송 정보를 이용하여 결제금액에 배송비를 계산한다.
		return applyShipping(priceData, shippingMethod);
	}

	private PriceData calculatePricingData(final Product product, final int quantity) {
		final int basePrice = product.basePrice() * quantity;
		final double discount = Math.max(quantity - product.discountThreshold(), 0)
			* product.basePrice() * product.discountRate();
		return new PriceData(basePrice, quantity, discount);
	}

	private double applyShipping(final PriceData priceData, final ShippingMethod shippingMethod) {
		final int shippingPerCase = (priceData.basePrice > shippingMethod.discountThreshold())
			? shippingMethod.discountedFee() : shippingMethod.feePerCase();
		final int shippingCost = priceData.quantity * shippingPerCase;
		return priceData.basePrice - priceData.discount + shippingCost;
	}

	private class PriceData {
		private int basePrice;
		private int quantity;
		private double discount;

		public PriceData(final int basePrice, final int quantity, final double discount) {
			this.basePrice = basePrice;
			this.quantity = quantity;
			this.discount = discount;
		}
	}
}
