package me.gaegul.refactoring.ch12.no10;

import java.util.Map;

public class BirdFactory {

	public static Bird createBird(Map<String, String> data) {
		return new Bird(data);
	}
}
