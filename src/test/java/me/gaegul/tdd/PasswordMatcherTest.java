package me.gaegul.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("패스워드는 모든 조건을 만족하면 강함이 반환된다.")
    @Test
    void all_matched() {
        PasswordMatcher matcher = new PasswordMatcher();
        PasswordStrength result = matcher.match("123456Ab");
        assertThat(result).isEqualTo(PasswordStrength.STRONG);
    }

    @DisplayName("패스워드는 길이가 8글자 이상이고 0~9숫자를 포함하면 보통을 반환한다.")
    @Test
    void without_text() {
        PasswordMatcher matcher = new PasswordMatcher();
        PasswordStrength result = matcher.match("12345600");
        assertThat(result).isEqualTo(PasswordStrength.NORMAL);
    }

    @DisplayName("패스워드는 0~9숫자를 포함하고 대문자를 포함하면 보통을 반환한다.")
    @Test
    void without_length() {
        PasswordMatcher matcher = new PasswordMatcher();
        PasswordStrength result = matcher.match("123456A");
        assertThat(result).isEqualTo(PasswordStrength.NORMAL);
    }

    @DisplayName("패스워드는 길이가 8글자 이상이고 대문자를 포함하면 보통을 반환한다.")
    @Test
    void without_number() {
        PasswordMatcher matcher = new PasswordMatcher();
        PasswordStrength result = matcher.match("asdwfcvsA");
        assertThat(result).isEqualTo(PasswordStrength.NORMAL);
    }
}
