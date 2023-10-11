package me.gaegul.refactoring.ch12.indirect_inheritance;

public class Employee {
	private String name;
	private EmployeeType type;

	public Employee(final String name, final String type) {
		this.name = name;
		this.type = createEmployeeType(type);
	}

	static EmployeeType createEmployeeType(final String value) {
		switch (value) {
			case "engineer": return new Engineer();
			case "manager": return new Manager();
			case "salesperson": return new SalesPerson();
			default: throw new IllegalArgumentException(String.format("%s라는 직원 유형은 없습니다.", value));
		}
	}

	public String typeString() {
		return this.type.toString();
	}

	public EmployeeType type() {
		return this.type;
	}


	public void setType(final String type) {
		this.type = createEmployeeType(type);
	}

	@Override
	public String toString() {
		return String.format("%s (%s)", this.name, this.type.capitalizedName());
	}
}
