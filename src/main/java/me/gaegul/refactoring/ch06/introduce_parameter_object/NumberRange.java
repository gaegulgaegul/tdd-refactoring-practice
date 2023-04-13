package me.gaegul.refactoring.ch06.introduce_parameter_object;

public class NumberRange {
	private final int min;
	private final int max;

	public NumberRange(final int min, final int max) {
		this.min = min;
		this.max = max;
	}

	boolean contains(final int temp) {
		return temp < this.min || temp > this.max;
	}
}
