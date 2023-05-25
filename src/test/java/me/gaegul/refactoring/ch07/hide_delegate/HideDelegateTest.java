package me.gaegul.refactoring.ch07.hide_delegate;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("위임 숨기기")
class HideDelegateTest {

	@DisplayName("사람과 사람이 속한 부서")
	@Test
	void personDepartment() {
		Department department = new Department();
		department.setChargeCode("CP1");
		department.setManager("오상식");

		Person person = new Person("장그레");
		person.setDepartment(department);

		assertThat(person.departmentManager()).isEqualTo("오상식");
	}
}
