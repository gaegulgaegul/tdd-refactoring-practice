package me.gaegul.refactoring.ch12.no10;

import java.util.Map;

public class Bird {
	private String name;		// 이름
	private String plumage;		// 깃털 생김새

	public Bird(Map<String, String> data) {
		this.name = data.get("type");
		this.plumage = data.get("plumage");
	}

	public String name() {
		return this.name;
	}

	public String plumage() {
		if (isEmptyPlumage()) {
			return "보통이다";
		}
		return this.plumage;
	}

	/**
	 * 비행 속력
	 */
	public int airSpeedVelocity() {
		return 0;
	}

	/**
	 * 깃털 생김새 빈 값 여부 반환
	 * 하위 클래스에서 필드 null 체크를 위해서 추가
	 */
	boolean isEmptyPlumage() {
		return this.plumage == null;
	}
}