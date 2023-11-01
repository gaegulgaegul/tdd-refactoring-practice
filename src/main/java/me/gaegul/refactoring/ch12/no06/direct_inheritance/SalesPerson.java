package me.gaegul.refactoring.ch12.no06.direct_inheritance;

public class SalesPerson extends Employee {
	public SalesPerson(String name) {
		super(name);
	}

	@Override
	public String type() {
		return "salesperson";
	}
}
