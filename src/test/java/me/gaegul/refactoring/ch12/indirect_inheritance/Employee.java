package me.gaegul.refactoring.ch12.indirect_inheritance;

import java.util.List;

public class Employee {
	private String name;
	private String type;

	public Employee(final String name, final String type) {
		this.validateType(type);
		this.name = name;
		this.type = type;
	}

	public String type() {
		return this.type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public String capitalizedType() {
		return this.type.substring(0, 1).toUpperCase() + this.type.substring(1, 2).toLowerCase();
	}

	@Override
	public String toString() {
		return String.format("%s (%s)", this.name, this.capitalizedType());
	}

	private void validateType(final String type) {
		if (!List.of("engineer", "manager", "salesperson").contains(type)) {
			throw new IllegalArgumentException(String.format("%s라는 직원 유형은 없습니다.", type));
		}
	}
}
