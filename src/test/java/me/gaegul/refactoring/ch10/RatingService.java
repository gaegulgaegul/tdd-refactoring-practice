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
        return new Rating(voyage, history).getValue();
    }

    public Rating createRating(final Voyage voyage, final List<History> history) {
        if ("중국".equals(voyage.getZone()) && history.stream().anyMatch(item -> "중국".equals(item.getZone()))) {
            return new ExperiencedChinaRaing(voyage, history);
        }
        return new Rating(voyage, history);
    }

    public static class ExperiencedChinaRaing extends Rating {

        public ExperiencedChinaRaing(Voyage voyage, List<History> history) {
            super(voyage, history);
        }

        @Override
        int captainHistoryRisk(final Voyage voyage, final List<History> history) {
            int result = super.captainHistoryRisk(voyage, history) - 2;
            return Math.max(result, 0);
        }
    }

    public static class Rating {
        private final Voyage voyage;
        private final List<History> history;

        public Rating(final Voyage voyage, final List<History> history) {
            this.voyage = voyage;
            this.history = history;
        }

        /**
         * 선장의 항해 이력 위험요소
         * @param voyage
         * @param history
         * @return
         */
        int captainHistoryRisk(final Voyage voyage, final List<History> history) {
            int result = 1;
            if (history.size() < 5)
                result += 4;
            result += history.stream().filter(item -> item.getProfit() < 0).count();
            if ("중국".equals(voyage.getZone()) && hasChina(history))
                result -= 2;
            return Math.max(result, 0);
        }

        private String getValue() {
            final int vpf = voyageProfitFactor(this.voyage, this.history);
            final int vr = voyageRisk(this.voyage);
            final int chr = captainHistoryRisk(this.voyage, this.history);
            if (vpf * 3 > (vr + chr * 2))
                return "A";
            return "B";
        }

        /**
         * 항해 경로 위험요소
         * @param voyage
         * @return
         */
        private int voyageRisk(final Voyage voyage) {
            int result = 1;
            if (voyage.length() > 4)
                result += 2;
            if (voyage.length() > 8)
                result += voyage.length() - 8;
            if (List.of("중국", "동인도").contains(voyage.getZone()))
                result += 4;
            return Math.max(result, 0);
        }

        /**
         * 중국을 경유하는가?
         * @param history
         * @return
         */
        private boolean hasChina(final List<History> history) {
            return history.stream().anyMatch(item -> "중국".equals(item.getZone()));
        }

        /**
         * 수익 요인
         * @param voyage
         * @param history
         * @return
         */
        private int voyageProfitFactor(final Voyage voyage, final List<History> history) {
            int result = 2;
            if ("중국".equals(voyage.getZone()))
                result += 1;
            if ("동인도".equals(voyage.getZone()))
                result += 1;
            if ("중국".equals(voyage.getZone()) && hasChina(history)) {
                result += 3;
                if (history.size() > 10)
                    result += 1;
                if (voyage.length() > 12)
                    result += 1;
                if (voyage.length() > 18)
                    result -= 1;
            } else {
                if (history.size() > 8)
                    result += 1;
                if (voyage.length() > 14)
                    result -= 1;
            }
            return result;
        }
    }
}
