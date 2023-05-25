package me.gaegul.refactoring.ch07.inline_class;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("클래스 인라인하기")
class InlineClassTest {

	@DisplayName("배송 추적")
	@Test
	void trackingInformation() {
		Shipment shipment = new Shipment("쿠팡", "TEAKBAE|5-8");
		assertThat(shipment.trackingInfo()).isEqualTo("쿠팡: TEAKBAE|5-8");
	}
}
