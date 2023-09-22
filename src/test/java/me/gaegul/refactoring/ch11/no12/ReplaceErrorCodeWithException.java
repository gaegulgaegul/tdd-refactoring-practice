package me.gaegul.refactoring.ch11.no12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceErrorCodeWithException {

	private static final Map<String, Integer> COUNTRY_DATA = new HashMap<>();
	private static final List<ErrorStatus> ERROR_LIST = new ArrayList<>();

	static {
		COUNTRY_DATA.put("대한민국", 33);
	}

	public int localShippingRules(String country) {
		Integer data = COUNTRY_DATA.get(country);
		if (data != null) return data.intValue();
		throw new OrderProcessingError(-23);
	}

	public int calculateShippingCosts(OrderData order) {
		int shippingRules = localShippingRules(order.country());
		if (shippingRules < 0) throw new RuntimeException("오류 코드가 다 사라지지 않았습니다.");
		return shippingRules;
	}

	public void calculateStatus(OrderData order) {
		try {
			calculateShippingCosts(order);
		} catch (OrderProcessingError e) {
			ERROR_LIST.add(new ErrorStatus(order, e.code()));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public List<ErrorStatus> getErrorList() {
		return Collections.unmodifiableList(ERROR_LIST);
	}
}
