package me.gaegul.refactoring.ch12.direct_inheritance;

public class EmployeeFactory {

	public static Employee createEmployee(final String name, final String type) {
		switch (type) {
			case "engineer":
				return new Engineer(name);
			case "manager":
				return new Manager(name);
			case "salesperson":
				return new SalesPerson(name);
		}
		throw new IllegalArgumentException(String.format("%s라는 직원 유형은 없습니다.", type));
	}
}
