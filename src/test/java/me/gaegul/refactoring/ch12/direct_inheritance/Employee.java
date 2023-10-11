package me.gaegul.refactoring.ch12.direct_inheritance;

import java.util.List;

public class Employee {
	private String name;
	private String type;

	public Employee(final String name, final String type) {
		this.name = name;
		this.type = type;
	}

	public void validateType() {
		if (isNotDefinedEmployeeType()) {
			throw new IllegalArgumentException(String.format("%s라는 직원 유형은 없습니다.", this.type));
		}
	}

	protected boolean isNotDefinedEmployeeType() {
		return !List.of("engineer", "manager", "salesperson").contains(this.type);
	}

	@Override
	public String toString() {
		return String.format("%s (%s)", this.name, this.type);
	}
}
