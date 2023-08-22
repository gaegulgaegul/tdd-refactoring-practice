package me.gaegul.refactoring.ch10.no5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("특이 케이스 추가하기")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CustomerOfInfraServiceTest {

	public static final String UNKNOWN_CUSTOMER = "미확인 고객";
	private CustomerOfInfraService sut;

	@BeforeEach
	void setUp() {
		this.sut = new CustomerOfInfraService();
	}

	@Nested
	class client1_메서드는 {

		@Nested
		class 미확인_고객의_현장을_전달하면 {

			@Test
			void 거주자가_반환된다() {
				final Site site = new Site(UNKNOWN_CUSTOMER);
				final String result = sut.client1(site);
				assertThat(result).isEqualTo("거주자");
			}
		}

		@Nested
		class 뽀로로_고객의_현장을_전달하면 {

			@Test
			void 뽀로로가_반환된다() {
				final Site site = new Site("뽀로로");
				final String result = sut.client1(site);
				assertThat(result).isEqualTo("뽀로로");
			}
		}
	}
	
	@Nested
	class client2_메서드는 {
		
		@Nested
		class 미확인_고객을_전달하면 {

			@Test
			void basic_요금제를_반환한다() {
				final Customer customer = new Customer(UNKNOWN_CUSTOMER);
				final BillingPlan result = sut.client2(customer);
				assertThat(result).isEqualTo(BillingPlan.BASIC);
			}
		}

		@Nested
		class premium_요금제를_사용하는_뽀로로_고객을_전달하면 {

			@Test
			void premium_요금제를_반환한다() {
				final Customer customer = new Customer("뽀로로", BillingPlan.PREMIUM);
				final BillingPlan result = sut.client2(customer);
				assertThat(result).isEqualTo(BillingPlan.PREMIUM);
			}
		}
	}

	@Nested
	class client3_메서드는 {
		
		@Nested
		class 미확인_고객을_전달하면 {

			@Test
			void 작년_주_당_지연일자_0을_반환한다() {
				final Customer customer = new Customer(UNKNOWN_CUSTOMER);
				int result = sut.client3(customer);
				assertThat(result).isZero();
			}
		}

		@Nested
		class 뽀로로_고객을_전달하면 {

			@Test
			void 작년_주_당_지연일자_0이외의_값을_반환한다() {
				final Customer customer = new Customer("뽀로로");
				int result = sut.client3(customer);
				assertThat(result).isNotZero();
			}
		}
	}
}