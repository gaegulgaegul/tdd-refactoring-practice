package me.gaegul.refactoring.ch07.hide_delegate;

public class Person {
	private final String name;
	private Department department;

	public Person(String name) {
		this.name = name;
	}

	public String name() {
		return this.name;
	}

	public Department department() {
		return this.department;
	}

	public void setDepartment(final Department department) {
		this.department = department;
	}

	public String departmentManager() {
		return this.department.manager();
	}
}
