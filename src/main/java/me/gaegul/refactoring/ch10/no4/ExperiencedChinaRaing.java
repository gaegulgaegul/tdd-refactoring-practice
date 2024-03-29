package me.gaegul.refactoring.ch10.no4;

import java.util.List;

public class ExperiencedChinaRaing extends Rating {

	public ExperiencedChinaRaing(Voyage voyage, List<History> history) {
		super(voyage, history);
	}

	@Override
	int captainHistoryRisk() {
		int result = super.captainHistoryRisk() - 2;
		return Math.max(result, 0);
	}

	@Override
	int voyageLengthFactor() {
		int result = 0;
		if (this.voyage().length() > 12)
			result += 1;
		if (this.voyage().length() > 18)
			result -= 1;
		return result;
	}

	@Override
	int historyLengthFactor() {
		return this.history().size() > 10 ? 1 : 0;
	}

	@Override
	int voyageProfitFactor() {
		return super.voyageProfitFactor() + 3;
	}
}
