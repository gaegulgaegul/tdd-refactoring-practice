package me.gaegul.refactoring.ch12.direct_inheritance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("EmployeeFactory_클래스의")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class EmployeeFactoryTest {

	@Nested
	class createEmployee_메서드는 {

		@Test
		void 엔지니어_타입인_경우_엔지니어_클래스를_반환한다() {
			assertThat(EmployeeFactory.createEmployee("엔지니어", "engineer")).isInstanceOf(Engineer.class);
		}

		@Test
		void 매니저_타입인_경우_매니저_클래스를_반환한다() {
			assertThat(EmployeeFactory.createEmployee("매니저", "manager")).isInstanceOf(Manager.class);
		}

		@Test
		void 영업사원_타입인_경우_영업사원_클래스를_반환한다() {
			assertThat(EmployeeFactory.createEmployee("영업사원", "salesperson")).isInstanceOf(SalesPerson.class);
		}

		@Test
		void 프로그래머_타입인_경우_예외가_발생한다() {
			assertThatThrownBy(() -> EmployeeFactory.createEmployee("프로그래머", "programmer"))
				.isInstanceOf(IllegalArgumentException.class);
		}
	}
}
