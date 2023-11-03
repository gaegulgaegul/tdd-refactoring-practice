package me.gaegul.refactoring.ch12.no10;

import java.util.Map;

public class BirdFactory {

	public static Bird createBird(Map<String, String> data) {
		switch (data.get("type")) {
			case "아프리카 제비":
				return new AfricanSwallow(data);
			case "노르웨이 파랑 앵무":
				return new NorwegianBlueParrot(data);
			default:
				return new Bird(data);
		}
	}
}
