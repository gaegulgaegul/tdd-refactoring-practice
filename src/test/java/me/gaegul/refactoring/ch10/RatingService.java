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

        @Override
        int voyageLengthFactor() {
            int result = 3;
            if (this.voyage().length() > 12) result += 1;
            if (this.voyage().length() > 18) result -= 1;
            return result;
        }

        @Override
        int historyLengthFactor() {
            return this.history().size() > 10 ? 1 : 0;
        }
    }

    public static class Rating {
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
            return Math.max(result, 0);
        }

        private String getValue() {
            final int vpf = voyageProfitFactor();
            final int vr = voyageRisk();
            final int chr = captainHistoryRisk(this.voyage, this.history);
            if (vpf * 3 > (vr + chr * 2))
                return "A";
            return "B";
        }

        /**
         * 항해 경로 위험요소
         *
         * @return
         */
        private int voyageRisk() {
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

        int voyageLengthFactor() {
            int result = 0;
            if (this.voyage.length() > 14) result -= 1;
            return result;
        }

        int historyLengthFactor() {
            return this.history.size() > 8 ? 1 : 0;
        }

        /**
         * 중국을 경유하는가?
         * @param history
         * @return
         */
        private boolean hasChina(final List<History> history) {
            return history.stream().anyMatch(item -> "중국".equals(item.getZone()));
        }
    }
}
