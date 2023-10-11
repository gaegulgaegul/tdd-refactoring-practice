package me.gaegul.refactoring.ch12.direct_inheritance;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("타입 코드를 서브클래스로 바꾸기")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class EmployeeTest {

	@Nested
	class Employee_클래스의 {

		@Nested
		class validateType_메서드는 {

			@Test
			void 엔지니어_타입을_가지는_직원이면_예외를_발생하지_않는다() {
				final Employee employee = new Employee("엔지니어", "engineer");
				employee.validateType();
			}

			@Test
			void 매니저_타입을_가지는_직원이면_예외를_발생하지_않는다() {
				final Employee employee = new Employee("매니저", "manager");
				employee.validateType();
			}

			@Test
			void 영업사원_타입을_가지는_직원이면_예외를_발생하지_않는다() {
				final Employee employee = new Employee("영업사원", "salesperson");
				employee.validateType();
			}

			@Test
			void 프로그래머_타입을_가지는_직원이면_예외가_발생한다() {
				final Employee employee = new Employee("프로그래머", "programmer");
				assertThatThrownBy(employee::validateType)
					.isInstanceOf(IllegalArgumentException.class);
			}
		}
	}

}