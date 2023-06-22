package me.gaegul.refactoring.ch08.move_statements_to_callers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("PersonWriter 클래스의")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PersonWriterTest {

	@Test
	void renderPerson_메서드_테스트() {
		Person person = new Person("둘리", new Photo("가족여행", LocalDate.now(), "서울, 대한민국"));
		PersonWriter personWriter = new PersonWriter();
		StringBuffer stringBuffer = new StringBuffer();
		personWriter.renderPerson(stringBuffer, person);

		assertThat(stringBuffer.toString()).isEqualTo("<p>둘리</p>\n"
			+ "<div>\n"
			+ "<p>제목: 가족여행</p>\n"
			+ "<p>날짜: 2023-06-22</p>\n"
			+ "<p>위치: 서울, 대한민국</p>\n"
			+ "</div>\n"
			+ "<p>제목: 가족여행</p>\n"
			+ "<p>날짜: 2023-06-22</p>\n"
			+ "<p>위치: 서울, 대한민국</p>\n");
	}
}