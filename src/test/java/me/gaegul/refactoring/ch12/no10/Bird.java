package me.gaegul.refactoring.ch12.no10;

import java.util.Map;

public class Bird {
	private String name;		// 이름
	private String plumage;		// 깃털 생김새
	private SpeciesDelegate speciesDelegate;

	public Bird(Map<String, String> data) {
		this.name = data.get("type");
		this.plumage = data.get("plumage");
		this.speciesDelegate = selectSpeciesDelegate(data);
	}

	private SpeciesDelegate selectSpeciesDelegate(Map<String, String> data) {
		switch (data.get("type")) {
			case "유럽 제비":
				return new EuropeanSwallowDelegate(data, this);
			case "아프리카 제비":
				return new AfricanSwallowDelegate(data, this);
			case "노르웨이 파랑 앵무":
				return new NorwegianBlueParrotDelegate(data, this);
			default:
				return new SpeciesDelegate(data, this);
		}
	}

	public String name() {
		return this.name;
	}

	public String plumage() {
		return this.speciesDelegate.plumage();
	}

	/**
	 * 비행 속력
	 */
	public int airSpeedVelocity() {
		return this.speciesDelegate == null ? 0 : this.speciesDelegate.airSpeedVelocity();
	}

	/**
	 * 깃털 생김새 빈 값 여부 반환
	 * 하위 클래스에서 필드 null 체크를 위해서 추가
	 */
	boolean isEmptyPlumage() {
		return this.plumage == null;
	}

	SpeciesDelegate getSpeciesDelegate() {
		return this.speciesDelegate;
	}

	String getPlumage() {
		return this.plumage;
	}
}
