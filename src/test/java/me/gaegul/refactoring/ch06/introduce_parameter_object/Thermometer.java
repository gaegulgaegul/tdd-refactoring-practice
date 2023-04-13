package me.gaegul.refactoring.ch06.introduce_parameter_object;

import java.util.List;
import java.util.stream.Collectors;

public class Thermometer {
	public List<Reading> readingOutsideRange(Station station, int min, int max) {
		return station.getReadings().stream()
			.filter(r -> r.getTemp() < min || r.getTemp() > max)
			.collect(Collectors.toList());
	}
}
