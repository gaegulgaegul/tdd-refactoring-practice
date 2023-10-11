package me.gaegul.refactoring.ch12.indirect_inheritance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Employee_클래스의")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class EmployeeTest {

	@Nested
	class 생성자는 {

		@Test
		void 엔지니어_타입_객체를_생성하면_성공한다() {
			assertThat(new Employee("엔지니어", "engineer"))
				.isInstanceOf(Employee.class);
		}

		@Test
		void 매니저_타입_객체를_생성하면_성공한다() {
			assertThat(new Employee("매니저", "manager"))
				.isInstanceOf(Employee.class);
		}

		@Test
		void 영업사원_타입_객체를_생성하면_성공한다() {
			assertThat(new Employee("영업사원", "salesperson"))
				.isInstanceOf(Employee.class);
		}

		@Test
		void 프로그래머_타입_객체를_생성하면_예외가_발생한다() {
			assertThatThrownBy(() -> new Employee("프로그래머", "programmer"))
				.isInstanceOf(IllegalArgumentException.class);
		}
	}

	@Nested
	class createEmployeeType_메서드는 {

		@Test
		void 엔지니어_타입을_전달하면_Engineer_타입을_반환한다() {
			assertThat(Employee.createEmployeeType("engineer"))
				.isInstanceOf(Engineer.class);
		}

		@Test
		void 매니저_타입을_전달하면_Manager_타입을_반환한다() {
			assertThat(Employee.createEmployeeType("manager"))
				.isInstanceOf(Manager.class);
		}

		@Test
		void 영업사원_타입을_전달하면_SalesPerson_타입을_반환한다() {
			assertThat(Employee.createEmployeeType("salesperson"))
				.isInstanceOf(SalesPerson.class);
		}

		@Test
		void 프로그래머_타입을_전달하면_예외가_발생한다() {
			assertThatThrownBy(() -> Employee.createEmployeeType("programmer"))
				.isInstanceOf(IllegalArgumentException.class);
		}
	}
}
