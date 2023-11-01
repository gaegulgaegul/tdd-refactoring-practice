package me.gaegul.refactoring.ch12.no10;

import java.util.Map;

/**
 * 유럽 제비
 */
public class EuropeanSwallow extends Bird {
	public EuropeanSwallow(Map<String, String> data) {
		super(data);
	}

	@Override
	public int airSpeedVelocity() {
		return 35;
	}
}
