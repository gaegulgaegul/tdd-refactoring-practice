package me.gaegul.refactoring.ch06.split_phase.file;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("JSON 파일에 담긴 주문의 개수 구하기 - 단계 쪼개기")
class JsonFileAppTest {

	@DisplayName("JSON 파일에 담긴 주문의 개수 구하기")
	@Test
	void run() throws IOException {
		long count = JsonFileApp.run(
			new String[] {"-r", "./JsonFile"});
		assertThat(count).isEqualTo(1L);
	}

	@DisplayName("JSON 파일에 읽기 명령을 주지 않는 경우 Order의 개수 반환")
	@Test
	void run_non_read_mode() throws IOException {
		long count = JsonFileApp.run(
			new String[] {"./JsonFile"});
		assertThat(count).isEqualTo(1L);
	}

	@DisplayName("JSON 파일이 없는 경우 예외 발생")
	@Test
	void run_except_case() {
		assertThatThrownBy(() -> JsonFileApp.run(new String[] {}))
			.isInstanceOf(RuntimeException.class);
	}
}