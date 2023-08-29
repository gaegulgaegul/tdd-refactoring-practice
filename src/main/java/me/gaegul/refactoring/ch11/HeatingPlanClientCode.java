package me.gaegul.refactoring.ch11;

/**
 * 실내 온도 제어 시스템 호출부
 */
public class HeatingPlanClientCode {
	private HeatingPlan thePlan;

	/**
	 * 온도 제어 수행
	 * @param thermostat
	 */
	public void action(Thermostat thermostat) {
		if (thePlan.getTargetTemperature(thermostat.selectedTemperature()) > thermostat.currentTemperature()) {
			setToHeat();
		} else if (thePlan.getTargetTemperature(thermostat.selectedTemperature()) < thermostat.currentTemperature()) {
			setToCool();
		} else {
			setOff();
		}
	}

	/**
	 * 온도 제어 장치를 종료한다.
	 */
	private void setOff() {}

	/**
	 * 온도를 낮춘다.
	 */
	private void setToCool() {}

	/**
	 * 온도를 높인다
	 */
	private void setToHeat() {}
}
