package me.gaegul.refactoring.ch12.no10;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("BirdFactory 클래스의")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BirdFactoryTest {

	@Nested
	class createBird_메서드는 {

		@Nested
		class 타입이_유럽_제비면 {
			private Map<String, String> data = Map.of("type", "유럽 제비");

			@Test
			void 유럽_제비_클래스_타입을_반환한다() {
				Bird bird = BirdFactory.createBird(data);
				assertThat(bird.getSpeciesDelegate()).isInstanceOf(EuropeanSwallowDelegate.class);
			}
		}

		@Nested
		class 타입이_아프리카_제비면 {
			private Map<String, String> data = Map.of("type", "아프리카 제비");

			@Test
			void 아프리카_제비_클래스_타입을_반환한다() {
				assertThat(BirdFactory.createBird(data)).isInstanceOf(Bird.class);
			}
		}

		@Nested
		class 타입이_노르웨이_파랑_앵무면 {
			private Map<String, String> data = Map.of("type", "노르웨이 파랑 앵무");

			@Test
			void 아프리카_제비_클래스_타입을_반환한다() {
				assertThat(BirdFactory.createBird(data)).isInstanceOf(Bird.class);
			}
		}
	}
}