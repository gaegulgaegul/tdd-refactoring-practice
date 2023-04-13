package me.gaegul.refactoring.ch06.introduce_parameter_object;

import java.util.List;

public class Station {
	private final String name;
	private final List<Reading> readings;

	public Station(final String name, final List<Reading> readings) {
		this.name = name;
		this.readings = readings;
	}

	public List<Reading> getReadings() {
		return readings;
	}
}
