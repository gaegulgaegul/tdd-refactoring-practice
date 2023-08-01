package me.gaegul.refactoring.ch10;

import java.util.List;

public class RatingService {

    /**
     * 투자 등급
     * @param voyage
     * @param history
     * @return
     */
    public String rating(final Voyage voyage, final List<History> history) {
        return createRating(voyage, history).getValue();
    }

    /**
     * 투자 등급 계산 클래스를 반환하는 팩토리 메서드
     * @param voyage
     * @param history
     * @return
     */
    private Rating createRating(final Voyage voyage, final List<History> history) {
        if ("중국".equals(voyage.getZone()) && history.stream().anyMatch(item -> "중국".equals(item.getZone()))) {
            return new ExperiencedChinaRaing(voyage, history);
        }
        return new Rating(voyage, history);
    }

}
