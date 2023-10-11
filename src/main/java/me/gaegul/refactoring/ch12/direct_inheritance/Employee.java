package me.gaegul.refactoring.ch12.direct_inheritance;

public abstract class Employee {
	private String name;

	public Employee(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("%s (%s)", this.name, this.type());
	}
	public abstract String type();
}
