package me.gaegul.refactoring.ch11;

public class Thermostat {
	private double selectedTemperature;
	private double currentTemperature;

	public Thermostat(final double selectedTemperature) {
		this.selectedTemperature = selectedTemperature;
	}

	public double selectedTemperature() {
		return this.selectedTemperature;
	}

	public double currentTemperature() {
		return this.currentTemperature;
	}
}
