package me.gaegul.refactoring.ch10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("변형 동작을 다형성으로 표현하기")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RatingServiceTest {

    RatingService ratingService;

    @BeforeEach
    void setUp() {
        this.ratingService = new RatingService();
    }

    @Test
    void 선박의_항해_투자_B등급_계산() {
        final Voyage voyage = new Voyage("서인도", 10);
        final List<History> history = List.of(
                new History("동인도", 5),
                new History("서인도", 15),
                new History("중국", -2),
                new History("서아프리카", 7)
        );
        String myRating = ratingService.rating(voyage, history);
        assertThat(myRating).isEqualTo("B");
    }

    @Test
    void 선박의_항해_투자_A등급_계산() {
        final Voyage voyage = new Voyage("중국", 13);
        final List<History> history = List.of(
            new History("동인도", 5),
            new History("서인도", 13),
            new History("중국", 14),
            new History("서아프리카", 7)
        );
        String myRating = ratingService.rating(voyage, history);
        assertThat(myRating).isEqualTo("A");
    }
}
