package me.gaegul.refactoring.ch10.no4;

import java.util.List;

public class Rating {
	private final Voyage voyage;
	private final List<History> history;

	public Rating(final Voyage voyage, final List<History> history) {
		this.voyage = voyage;
		this.history = history;
	}

	public Voyage voyage() {
		return this.voyage;
	}

	public List<History> history() {
		return this.history;
	}

	/**
	 * 투자 등급 반환
	 * @return
	 */
	String getValue() {
		final int vpf = voyageProfitFactor();
		final int vr = voyageRisk();
		final int chr = captainHistoryRisk();
		if (vpf * 3 > (vr + chr * 2))
			return "A";
		return "B";
	}

	/**
	 * 선장의 항해 이력 위험요소
	 * @return
	 */
	int captainHistoryRisk() {
		int result = 1;
		if (this.history.size() < 5)
			result += 4;
		result += this.history.stream().filter(item -> item.getProfit() < 0).count();
		return Math.max(result, 0);
	}

	/**
	 * 항해 경로 위험요소
	 * @return
	 */
	int voyageRisk() {
		int result = 1;
		if (this.voyage.length() > 4)
			result += 2;
		if (this.voyage.length() > 8)
			result += this.voyage.length() - 8;
		if (List.of("중국", "동인도").contains(this.voyage.getZone()))
			result += 4;
		return Math.max(result, 0);
	}

	/**
	 * 수익 요인
	 * @return
	 */
	int voyageProfitFactor() {
		int result = 2;
		if ("중국".equals(this.voyage.getZone()))
			result += 1;
		if ("동인도".equals(this.voyage.getZone()))
			result += 1;
		result += historyLengthFactor();
		result += voyageLengthFactor();
		return result;
	}

	/**
	 * 목적지 거리를 통해 팩터 반환
	 * @return
	 */
	int voyageLengthFactor() {
		return this.voyage.length() > 14 ? -1 : 0;
	}

	/**
	 * 이력 길이를 통해 팩터 반환
	 * @return
	 */
	int historyLengthFactor() {
		return this.history.size() > 8 ? 1 : 0;
	}
}
