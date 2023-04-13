package me.gaegul.refactoring.ch06.combine_functions_into_transform;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("차 계량 측정기 - 여러 함수를 변환 함수로 묶기")
class CarMeterTest {

	@DisplayName("클라이언트 1 - 기본 가격 측정")
	@Test
	void client1() {
		Reading aReading = acquireReading();
		int baseCharge = baseRate(aReading.month(), aReading.year()) * aReading.quantity();
		assertThat(baseCharge).isEqualTo(0);
	}

	@DisplayName("클라이언트 2 - 차 소비량 면세 가격 측정")
	@Test
	void client2() {
		Reading aReading = acquireReading();
		int base = (baseRate(aReading.month(), aReading.year()) * aReading.quantity());
		int taxableCharge = Math.max(0, base - taxThreshold(aReading.year()));
		assertThat(taxableCharge).isEqualTo(0);
	}

	@DisplayName("클라이언트 3 - 기본 가격 측정 캡슐화")
	@Test
	void client3() {
		Reading rawReading = acquireReading();
		Reading aReading = enrichReading(rawReading);
		int baseCharge = aReading.getBaseCharge();
		assertThat(baseCharge).isEqualTo(0);
	}

	private int calculateBaseCharge(Reading aReading) {
		return baseRate(aReading.month(), aReading.year()) * aReading.quantity();
	}

	private int taxThreshold(int year) {
		return 0;
	}

	private int baseRate(int month, int year) {
		return 0;
	}

	private Reading acquireReading() {
		return new Reading("ivan", 10, 5, 2017);
	}

	private Reading enrichReading(Reading original) {
		Reading result = original.clone();
		result.setBaseCharge(calculateBaseCharge(result));
		return result;
	}
}
