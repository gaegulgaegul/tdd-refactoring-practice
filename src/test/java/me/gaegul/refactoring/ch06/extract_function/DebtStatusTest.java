package me.gaegul.refactoring.ch06.extract_function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("함수 추출하기 - 고객의 채무 사항 출력")
public class DebtStatusTest {

    @DisplayName("유효범위를 벗어나는 변수가 없을 때")
    @Test
    void printOwing() {
        DebtStatus debtStatus = new DebtStatus();
        Invoice invoice = new Invoice();
        String owing = debtStatus.getOwing(invoice);
        assertThat(owing).isEqualTo("");
    }
}
