package me.gaegul.refactoring.ch11.no06;

/**
 * 온도 정보 관리
 */
public class Thermostat {
	private double selectedTemperature;
	private double currentTemperature;

	public Thermostat(final double selectedTemperature) {
		this.selectedTemperature = selectedTemperature;
	}

	/**
	 * 설정 온도 반환
	 * @return
	 */
	public double selectedTemperature() {
		return this.selectedTemperature;
	}

	/**
	 * 현재 온도 반환
	 * @return
	 */
	public double currentTemperature() {
		return this.currentTemperature;
	}
}
