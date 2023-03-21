package me.gaegul.refactoring.ch06.inline_method;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("함수 인라인하기 - 고객 정보 보고")
public class CustomerReportTest {

    @DisplayName("보고서 정보 추가 인라인 테스트")
    @Test
    void reportLines() {
        CustomerReport customerReport = new CustomerReport();
        Customer customer = new Customer("홍길동", "서울");
        List<List<String>> results = customerReport.reportLines(customer);
        assertThat(results).isEqualTo(List.of(List.of("name", "홍길동"), List.of("location", "서울")));
    }
}
