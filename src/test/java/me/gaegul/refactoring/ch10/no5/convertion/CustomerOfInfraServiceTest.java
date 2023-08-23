package me.gaegul.refactoring.ch10.no5.convertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@DisplayName("특이 케이스 추가하기")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CustomerOfInfraServiceTest {

	private static final String UNKNOWN_SITE_JSON_PATH = "src/test/java/me/gaegul/refactoring/ch10/no5/convertion/unknownSite.json";
	private static final String SITE_JSON_PATH = "src/test/java/me/gaegul/refactoring/ch10/no5/convertion/site.json";

	private CustomerOfInfraService sut;
	private ObjectMapper objectMapper;

	@BeforeEach
	void setUp() {
		this.sut = new CustomerOfInfraService();
		this.objectMapper = new ObjectMapper();
		this.objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}

	@Nested
	class client1_메서드는 {

		@Nested
		class 미확인_고객의_현장을_전달하면 {

			@Test
			void 거주자가_반환된다() {
				final Site site = readSiteFor(UNKNOWN_SITE_JSON_PATH);
				final String result = sut.client1(site);
				assertThat(result).isEqualTo("거주자");
			}


		}

		@Nested
		class 확인_고객의_현장을_전달하면 {

			@Test
			void 확인_고객명이_반환된다() {
				final Site site = readSiteFor(SITE_JSON_PATH);
				final String result = sut.client1(site);
				assertThat(result).isEqualTo("애크미 산업");
			}
		}
	}
	
	@Nested
	class client2_메서드는 {

		@Nested
		class 미확인_고객을_전달하면 {

			@Test
			void basic_요금제를_반환한다() {
				final Site site = readSiteFor(UNKNOWN_SITE_JSON_PATH);
				final Customer customer = site.customer();
				final BillingPlan result = sut.client2(customer);
				assertThat(result).isEqualTo(BillingPlan.BASIC);
			}
		}

		@Nested
		class plan_451_요금제를_사용하는_확인_고객을_전달하면 {

			@Test
			void plan_451_요금제를_반환한다() {
				final Site site = readSiteFor(SITE_JSON_PATH);
				final Customer customer = site.customer();
				final BillingPlan result = sut.client2(customer);
				assertThat(result).isEqualTo(BillingPlan.PLAN_451);
			}
		}
	}

	@Nested
	class client3_메서드는 {

		@Nested
		class 미확인_고객을_전달하면 {

			@Test
			void 작년_주_당_지연일자_0을_반환한다() {
				final Site site = readSiteFor(UNKNOWN_SITE_JSON_PATH);
				final Customer customer = site.customer();
				int result = sut.client3(customer);
				assertThat(result).isZero();
			}
		}

		@Nested
		class 확인_고객을_전달하면 {

			@Test
			void 작년_주_당_지연일자_0이외의_값을_반환한다() {
				final Site site = readSiteFor(SITE_JSON_PATH);
				final Customer customer = site.customer();
				int result = sut.client3(customer);
				assertThat(result).isNotZero();
			}
		}
	}

	private Site readSiteFor(final String path) {
		try {
			return objectMapper.readValue(Path.of(path).toFile(), Site.class);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}