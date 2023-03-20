package me.gaegul.refactoring.ch06.extract_function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("함수 추출하기 - 고객의 채무 사항 출력")
public class DebtStatusTest {

    @DisplayName("유효범위를 벗어나는 변수가 없을 때")
    @Test
    void printOwing() {
        DebtStatus debtStatus = new DebtStatus();
        Invoice invoice = new Invoice("홍길동", List.of(new Order(100), new Order(200)));
        String owing = debtStatus.getOwing(invoice);
        assertThat(owing).isEqualTo("**********************\n" +
                "****   고객 채무   ****\n" +
                "**********************\n" +
                "고객명: 홍길동\n" +
                "채무액: 300\n" +
                "마감일: 2023-04-19");
    }
}
