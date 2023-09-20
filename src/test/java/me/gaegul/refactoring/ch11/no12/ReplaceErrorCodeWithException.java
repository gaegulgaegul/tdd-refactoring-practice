package me.gaegul.refactoring.ch11.no12;

import java.util.HashMap;
import java.util.Map;

public class ReplaceErrorCodeWithException {

	private static final Map<String, Integer> COUNTRY_DATA = new HashMap<>();

	static {
		COUNTRY_DATA.put("대한민국", 33);
	}

	public int localShippingRules(String country) {
		Integer data = COUNTRY_DATA.get(country);
		if (data != null) return data.intValue();
		return -23;
	}

	public int calculateShippingCosts(OrderData order) {
		int shippingRules = localShippingRules(order.country());
		if (shippingRules < 0) return shippingRules;
		return shippingRules;
	}
}
