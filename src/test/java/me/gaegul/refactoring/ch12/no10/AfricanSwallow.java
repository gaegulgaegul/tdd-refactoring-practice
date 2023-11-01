package me.gaegul.refactoring.ch12.no10;

import java.util.Map;

/**
 * 아프리카 제비
 */
public class AfricanSwallow extends Bird {
	private int numberOfCocounts;

	public AfricanSwallow(Map<String, String> data) {
		super(data);
		this.numberOfCocounts = Integer.valueOf(data.getOrDefault("numberOfCocounts", "0")).intValue();
	}

	@Override
	public int airSpeedVelocity() {
		return 40 - 2 * this.numberOfCocounts;
	}
}
