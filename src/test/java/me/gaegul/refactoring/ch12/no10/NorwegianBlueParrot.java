package me.gaegul.refactoring.ch12.no10;

import java.util.Map;

/**
 * 노르웨이 파랑 앵무
 */
public class NorwegianBlueParrot extends Bird {
	private int voltage;			// 	전압
	private boolean isNailed;		// 발톱을 가지고 있는지 유무

	public NorwegianBlueParrot(Map<String, String> data) {
		super(data);
		this.voltage = Integer.valueOf(data.getOrDefault("voltage", "0")).intValue();
		this.isNailed = Boolean.valueOf(data.getOrDefault("isNailed", "false")).booleanValue();
	}

	@Override
	public String plumage() {
		if (this.voltage > 100) return "그을렸다.";
		if (super.isEmptyPlumage()) return "예쁘다.";
		return super.plumage();
	}

	@Override
	public int airSpeedVelocity() {
		return this.isNailed ? 0 : 10 + this.voltage / 10;
	}
}
