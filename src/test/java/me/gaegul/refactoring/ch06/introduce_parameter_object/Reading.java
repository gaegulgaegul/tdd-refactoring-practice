package me.gaegul.refactoring.ch06.introduce_parameter_object;

public class Reading {
	private int temp;
	private String time;

	public Reading(final int temp, final String time) {
		this.temp = temp;
		this.time = time;
	}

	public int getTemp() {
		return this.temp;
	}
}
