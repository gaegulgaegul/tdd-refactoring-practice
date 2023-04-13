package me.gaegul.refactoring.ch06.combine_functions_into_class;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("차 계량 측정기 - 여러 함수를 클래스로 묶기")
class CarMeterTest {

	@DisplayName("클라이언트 1 - 기본 가격 측정")
	@Test
	void client1() {
		Reading rawReading = acquireReading();
		Reading aReading = new Reading(rawReading);
		int baseCharge = aReading.baseCharge();
		assertThat(baseCharge).isEqualTo(0);
	}

	@DisplayName("클라이언트 2 - 차 소비량 면세 가격 측정")
	@Test
	void client2() {
		Reading rawReading = acquireReading();
		Reading aReading = new Reading(rawReading);
		int taxableCharge = aReading.taxableCharge();
		assertThat(taxableCharge).isEqualTo(0);
	}

	@DisplayName("클라이언트 3 - 기본 가격 측정 캡슐화")
	@Test
	void client3() {
		Reading rawReading = acquireReading();
		Reading aReading = new Reading(rawReading);
		int baseCharge = aReading.baseCharge();
		assertThat(baseCharge).isEqualTo(0);
	}

	private Reading acquireReading() {
		return new Reading("ivan", 10, 5, 2017);
	}
}
