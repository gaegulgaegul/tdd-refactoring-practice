package me.gaegul.refactoring.ch11;

/**
 * 실내 온도 제어 시스템
 */
public class HeatingPlan {

	protected static final double MAX = 50.0;
	protected static final double MIN = 16.0;
	private final Thermostat thermostat;

	public HeatingPlan(final Thermostat thermostat) {
		this.thermostat = thermostat;
	}

	/**
	 * 목표 온도 반환
	 * @return
	 */
	public double getTargetTemperature() {
		if (this.thermostat.selectedTemperature() > MAX) {
			return MAX;
		} else if (this.thermostat.selectedTemperature() < MIN) {
			return MIN;
		} else {
			return this.thermostat.selectedTemperature();
		}
	}

}
