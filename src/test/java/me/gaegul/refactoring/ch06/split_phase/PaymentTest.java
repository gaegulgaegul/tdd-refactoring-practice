package me.gaegul.refactoring.ch06.split_phase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("상품의 결재 금액을 계산하는 테스트 - 단계 쪼개기")
class PaymentTest {

	@DisplayName("상품 결재 금액을 확인한다.")
	@Test
	void priceOrder() {
		Payment payment = new Payment();
		Product product = new Product(10000, 50, 0.4);
		ShippingMethod shippingMethod = new ShippingMethod(9000, 1000, 500);
		double result = payment.priceOrder(product, 100, shippingMethod);
		assertThat(result).isEqualTo(900000.0);
	}
}
