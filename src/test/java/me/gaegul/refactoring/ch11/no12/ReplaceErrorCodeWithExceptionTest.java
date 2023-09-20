package me.gaegul.refactoring.ch11.no12;

import static org.assertj.core.api.Assertions.assertThat;

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
}
