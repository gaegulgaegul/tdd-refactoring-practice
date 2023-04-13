package me.gaegul.refactoring.ch06.introduce_parameter_object;

import java.util.List;
import java.util.stream.Collectors;

public class Thermometer {
	public List<Reading> readingOutsideRange(Station station, NumberRange numberRange) {
		return station.getReadings().stream()
			.filter(r -> numberRange.contains(r.getTemp()))
			.collect(Collectors.toList());
	}

}
