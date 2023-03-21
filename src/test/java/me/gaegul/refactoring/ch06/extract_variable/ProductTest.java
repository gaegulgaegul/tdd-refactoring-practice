package me.gaegul.refactoring.ch06.extract_variable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("변수 추출하기 - 상품 가격 구하기")
public class ProductTest {

    @DisplayName("상품 가격 테스트")
    @Test
    void price() {
        Product product = new Product();
        Order order = new Order(5, 1000);
        double result = order.price();
        assertThat(result).isEqualTo(5100.0);
    }
}
