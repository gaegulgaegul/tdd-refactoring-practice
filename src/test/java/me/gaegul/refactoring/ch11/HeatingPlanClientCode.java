package me.gaegul.refactoring.ch11;

public class HeatingPlanClientCode {
	private HeatingPlan thePlan;

	public void action(Thermostat thermostat) {
		if (thePlan.getTargetTemperature() > thermostat.currentTemperature()) {
			setToHeat();
		} else if (thePlan.getTargetTemperature() < thermostat.currentTemperature()) {
			setToCool();
		} else {
			setOff();
		}
	}

	private void setOff() {

	}

	private void setToCool() {

	}

	private void setToHeat() {

	}
}
