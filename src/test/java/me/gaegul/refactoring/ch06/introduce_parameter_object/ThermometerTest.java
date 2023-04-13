package me.gaegul.refactoring.ch06.introduce_parameter_object;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("온도 측정값 표현 - 매개변수 객체 만들기")
class ThermometerTest {

	private static final Station STATION = new Station(
		"ZB1",
		List.of(
			new Reading(47, "2016-11-10 09:10"),
			new Reading(53, "2016-11-10 09:20"),
			new Reading(58, "2016-11-10 09:30"),
			new Reading(53, "2016-11-10 09:40"),
			new Reading(51, "2016-11-10 09:50")
		)
	);

	@DisplayName("온도 측정")
	@Test
	void readingOutsideRange() {
		final Thermometer thermometer = new Thermometer();
		final NumberRange numberRange = new NumberRange(45, 57);
		final List<Reading> results = thermometer.readingOutsideRange(STATION, numberRange);
		assertThat(results).singleElement();
	}

}
