package me.gaegul.refactoring.ch11;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("질의 함수를 매개변수로 바꾸기")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class HeatingPlanTest {

	private HeatingPlan heatingPlan;

	@BeforeEach
	void setUp() {
		heatingPlan = new HeatingPlan();
	}

	@Nested
	class getTargetTemperature_메서드는 {

		@Nested
		class 선택온도가_최대_온도보다_크면 {

			@Test
			void 최대_온도가_반환된다() {
				assertTargetTemperature(HeatingPlan.MAX + 0.1, HeatingPlan.MAX);
			}
		}

		@Nested
		class 선택온도가_최저_온도보다_작으면 {

			@Test
			void 최저_온도가_반환된다() {
				assertTargetTemperature(HeatingPlan.MIN - 0.1, HeatingPlan.MIN);
			}
		}

		@Nested
		class 선택온도가_최고_최저_사이_온도로 {

			@Test
			void 온도_50도를_전달하면_해당_온도가_반환된다() {
				assertTargetTemperature(50, 50);
			}

			@Test
			void 온도_16도를_전달하면_해당_온도가_반환된다() {
				assertTargetTemperature(16, 16);
			}

			@Test
			void 온도_30도를_전달하면_해당_온도가_반환된다() {
				assertTargetTemperature(30, 30);
			}
		}
	}

	private void assertTargetTemperature(final double selectedTemperature, final double expected) {
		final Thermostat thermostat = new Thermostat(selectedTemperature);
		final double result = heatingPlan.getTargetTemperature(thermostat.selectedTemperature());
		assertThat(result).isEqualTo(expected);
	}

}