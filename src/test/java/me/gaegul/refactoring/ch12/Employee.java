package me.gaegul.refactoring.ch12;

import java.util.List;

public class Employee {
	private String name;
	private String type;

	public void validateType(final String type) {
		if (!List.of("engineer", "manager", "salesperson").contains(type)) {
			throw new IllegalArgumentException(String.format("%s라는 직원 유형은 없습니다.", type));
		}
	}

	@Override
	public String toString() {
		return String.format("%s (%s)", this.name, this.type);
	}
}
