package me.gaegul.refactoring.ch12.no06.indirect_inheritance;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import me.gaegul.refactoring.ch12.no06.indirect_inheritance.EmployeeType;

@DisplayName("EmployeeType 클래스의")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class EmployeeTypeTest {

	@Nested
	class capitalizedName_메서드는 {

		@Test
		void 엔지니어_타입인_경우_En을_반환한다() {
			final EmployeeType employeeType = new EmployeeType("engineer");
			assertThat(employeeType.capitalizedName()).isEqualTo("En");
		}

		@Test
		void 매니저_타입인_경우_Ma을_반환한다() {
			final EmployeeType employeeType = new EmployeeType("manager");
			assertThat(employeeType.capitalizedName()).isEqualTo("Ma");
		}

		@Test
		void 영업사원_타입인_경우_Sa을_반환한다() {
			final EmployeeType employeeType = new EmployeeType("salesperson");
			assertThat(employeeType.capitalizedName()).isEqualTo("Sa");
		}
	}

}