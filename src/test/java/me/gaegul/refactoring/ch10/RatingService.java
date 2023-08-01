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
        int captainHistoryRisk() {
            int result = super.captainHistoryRisk() - 2;
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
         * @return
         */
        int captainHistoryRisk() {
            int result = 1;
            if (this.history.size() < 5)
                result += 4;
            result += this.history.stream().filter(item -> item.getProfit() < 0).count();
            return Math.max(result, 0);
        }

        String getValue() {
            final int vpf = voyageProfitFactor();
            final int vr = voyageRisk();
            final int chr = captainHistoryRisk();
            if (vpf * 3 > (vr + chr * 2))
                return "A";
            return "B";
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
}
