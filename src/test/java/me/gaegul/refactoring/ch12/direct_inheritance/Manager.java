package me.gaegul.refactoring.ch12.direct_inheritance;

public class Manager extends Employee {
	public Manager(String name) {
		super(name);
	}

	@Override
	public String type() {
		return "manager";
	}
}
