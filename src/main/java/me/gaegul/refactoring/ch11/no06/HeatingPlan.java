package me.gaegul.refactoring.ch11.no06;

/**
 * 실내 온도 제어 시스템
 */
public class HeatingPlan {

	protected static final double MAX = 50.0;
	protected static final double MIN = 16.0;

	/**
	 * 목표 온도 반환
	 * @param selectedTemperature
	 * @return
	 */
	public double getTargetTemperature(final double selectedTemperature) {
		if (selectedTemperature > MAX) {
			return MAX;
		} else if (selectedTemperature < MIN) {
			return MIN;
		} else {
			return selectedTemperature;
		}
	}

}
