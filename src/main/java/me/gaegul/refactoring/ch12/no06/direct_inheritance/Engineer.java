package me.gaegul.refactoring.ch12.no06.direct_inheritance;

public class Engineer extends Employee {
	public Engineer(String name) {
		super(name);
	}

	@Override
	public String type() {
		return "engineer";
	}
}
