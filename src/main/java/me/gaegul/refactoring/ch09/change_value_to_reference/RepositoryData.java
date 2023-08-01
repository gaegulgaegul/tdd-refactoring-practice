package me.gaegul.refactoring.ch09.change_value_to_reference;

import java.util.Map;

public class RepositoryData {
	private Map<Long, Customer> customers;

	public Map<Long, Customer> customers() {
		return this.customers;
	}
}
