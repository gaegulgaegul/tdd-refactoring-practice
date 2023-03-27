package me.gaegul.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("패스워드 강도 측정 기능 테스트")
public class PasswordMatcherTest {

    @DisplayName("null이면 예외발생")
    @Test
    void null_check() {
        PasswordMatcher matcher = new PasswordMatcher();
        assertThatThrownBy(() -> matcher.match(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 값이면 예외발생")
    @Test
    void empty_check() {
        PasswordMatcher matcher = new PasswordMatcher();
        assertThatThrownBy(() -> matcher.match(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
