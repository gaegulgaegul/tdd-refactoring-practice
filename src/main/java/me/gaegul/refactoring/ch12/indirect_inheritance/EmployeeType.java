package me.gaegul.refactoring.ch12.indirect_inheritance;

public class EmployeeType {
	private String value;

	EmployeeType(final String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}

	public String capitalizedName() {
		return this.value.substring(0, 1).toUpperCase() + this.value.substring(1, 2).toLowerCase();
	}
}
