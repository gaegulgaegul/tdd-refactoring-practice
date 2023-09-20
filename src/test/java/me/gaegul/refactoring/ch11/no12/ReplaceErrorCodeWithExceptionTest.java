package me.gaegul.refactoring.ch11.no12;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("오류 코드를 예외로 바꾸기")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ReplaceErrorCodeWithExceptionTest {

	private ReplaceErrorCodeWithException sut;

	@BeforeEach
	void setUp() {
		this.sut = new ReplaceErrorCodeWithException();
	}

	@Nested
	class localShippingRules_메서드는 {

		@Nested
		class 존재하는_국가인_경우 {

			@Test
			void 값을_반환한다() {
				int result = sut.localShippingRules("대한민국");
				assertThat(result).isGreaterThan(0);
				assertThat(result).isNotEqualTo(-23);
			}
		}

		@Nested
		class 존재하지_않는_국가인_경우 {

			@Test
			void 오류_코드를_반환한다() {
				int result = sut.localShippingRules("북한");
				assertThat(result).isEqualTo(-23);
			}
		}
	}

	@Nested
	class calculateShippingCosts_메서드는 {

		@Nested
		class 배송지의_규칙이_0보다_작으면 {

			@Test
			void 오류_코드를_반환한다() {
				OrderData order = new OrderData("북한");
				int result = sut.calculateShippingCosts(order);
				assertThat(result).isEqualTo(-23);
			}
		}

		@Nested
		class 배송지의_규칙이_0보다_크면 {

			@Test
			void 규칙을_반환한다() {
				OrderData order = new OrderData("대한민국");
				int result = sut.calculateShippingCosts(order);
				assertThat(result).isGreaterThan(0);
				assertThat(result).isNotEqualTo(-23);
				assertThat(result).isEqualTo(33);
			}
		}
	}

	@Nested
	class calculateStatus_메서드는 {

		@Nested
		class 배송지의_규칙을_알아낼_수_없으면 {

			@Test
			void 오류목록에_데이터를_추가한다() {
				OrderData order = new OrderData("북한");
				sut.calculateStatus(order);
				List<ErrorStatus> errorList = sut.getErrorList();
				assertThat(errorList).hasSize(1);
				assertThat(errorList.get(0).toString()).isEqualTo("");
			}
		}

		@Nested
		class 배송지의_규칙을_알아내면 {

			@Test
			void 오류목록에_데이터를_추가하지_않는다() {
				OrderData order = new OrderData("대한민국");
				sut.calculateStatus(order);
				List<ErrorStatus> errorList = sut.getErrorList();
				assertThat(errorList).isEmpty();
			}
		}
	}
}
