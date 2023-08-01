package me.gaegul.refactoring.ch09.change_value_to_reference;

import java.util.Map;

public class Order {
	private Long number;
	private Customer customer;

	public Order(Map<String, Long> data) {
		this.number = data.get("number");
		this.customer = CustomerRepository.registerCustomer(data.get("customer"));
	}
}
