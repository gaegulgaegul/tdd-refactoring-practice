package me.gaegul.refactoring.ch12.indirect_inheritance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import me.gaegul.refactoring.ch12.direct_inheritance.EmployeeFactory;
import me.gaegul.refactoring.ch12.direct_inheritance.Engineer;
import me.gaegul.refactoring.ch12.direct_inheritance.Manager;
import me.gaegul.refactoring.ch12.direct_inheritance.SalesPerson;

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
	class capitalizedType_메서드는 {

		@Test
		void 엔지니어_타입인_경우_En을_반환한다() {
			final Employee employee = new Employee("엔지니어", "engineer");
			assertThat(employee.capitalizedType()).isEqualTo("En");
		}

		@Test
		void 매니저_타입인_경우_Ma을_반환한다() {
			final Employee employee = new Employee("매니저", "manager");
			assertThat(employee.capitalizedType()).isEqualTo("Ma");
		}

		@Test
		void 영업사원_타입인_경우_Sa을_반환한다() {
			final Employee employee = new Employee("영업사원", "salesperson");
			assertThat(employee.capitalizedType()).isEqualTo("Sa");
		}
	}
}
