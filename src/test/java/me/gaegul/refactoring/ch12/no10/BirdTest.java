package me.gaegul.refactoring.ch12.no10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Bird 클래스의")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BirdTest {

	@Nested
	class 타입이_유럽_제비인_경우 {

		@Nested
		class plumage를_입력하면 {
			@Test
			void 입력값를_반환한다() {
				Map<String, String> data = Map.of(
					"type", "유럽 제비",
					"plumage", "갈색빛"
				);
				Bird bird = BirdFactory.createBird(data);
				assertThat(bird.plumage()).isEqualTo("갈색빛");
			}
		}
		@Nested
		class plumage를_입력하지_않으면 {
			@Test
			void 기본값를_반환한다() {
				Map<String, String> data = Map.of("type", "유럽 제비");
				Bird bird = BirdFactory.createBird(data);
				assertThat(bird.plumage()).isEqualTo("보통이다");
			}
		}

		@Test
		void 비행속력은_기본값를_반환한다() {
			Map<String, String> data = Map.of("type", "유럽 제비");
			Bird bird = BirdFactory.createBird(data);
			assertThat(bird.airSpeedVelocity()).isEqualTo(35);
		}
	}

	@Nested
	class 타입이_아프리카_제비인_경우 {

		@Nested
		class numberOfCocounts를_입력하면 {
			@Test
			void 비행속력을_반환한다() {
				Map<String, String> data = Map.of(
					"type", "아프리카 제비",
					"numberOfCocounts", "10"
				);
				Bird bird = BirdFactory.createBird(data);
				assertThat(bird.airSpeedVelocity()).isEqualTo(20);
			}
		}
	}

	@Nested
	class 타입이_노르웨이_파랑_앵무인_경우 {

		@Nested
		class plumage를_입력하면 {
			@Test
			void plumage은_입력값를_반환한다() {
				Map<String, String> data = Map.of(
					"type", "노르웨이 파랑 앵무",
					"plumage", "파랑빛"
				);
				Bird bird = BirdFactory.createBird(data);
				assertThat(bird.plumage()).isEqualTo("파랑빛");
			}
		}

		@Nested
		class voltage에_101을_전달하면 {
			@Test
			void plumage은_임계치_결과_문구를_반환한다() {
				Map<String, String> data = Map.of(
					"type", "노르웨이 파랑 앵무",
					"voltage", "101"
				);
				Bird bird = BirdFactory.createBird(data);
				assertThat(bird.plumage()).isEqualTo("그을렸다");
			}
		}

		@Nested
		class plumage를_입력하지_않으면 {
			@Test
			void plumage은_기본값를_반환한다() {
				Map<String, String> data = Map.of("type", "노르웨이 파랑 앵무");
				Bird bird = BirdFactory.createBird(data);
				assertThat(bird.plumage()).isEqualTo("예쁘다");
			}
		}

		@Nested
		class isNailed에_true를_입력하면 {

			@Test
			void 비행속력은_0을_반환한다() {
				Map<String, String> data = Map.of(
					"type", "노르웨이 파랑 앵무",
					"isNailed", "true"
				);
				Bird bird = BirdFactory.createBird(data);
				assertThat(bird.airSpeedVelocity()).isEqualTo(0);
			}
		}

		@Nested
		class isNailed에_false를_valtage는_101을_입력하면 {

			@Test
			void 비행속력은_계산값을_반환한다() {
				Map<String, String> data = Map.of(
					"type", "노르웨이 파랑 앵무",
					"isNailed", "false",
					"voltage", "101"
				);
				Bird bird = BirdFactory.createBird(data);
				assertThat(bird.airSpeedVelocity()).isEqualTo(20);
			}
		}
	}
}