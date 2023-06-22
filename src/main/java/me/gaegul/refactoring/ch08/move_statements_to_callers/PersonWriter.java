package me.gaegul.refactoring.ch08.move_statements_to_callers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PersonWriter {

	public void renderPerson(StringBuffer stringBuffer, Person person) {
		stringBuffer.append(String.format("<p>%s</p>\n", person.name()));
		renderPhoto(stringBuffer, person.photo());
		emitPhotoData(stringBuffer, person.photo());
		stringBuffer.append(String.format("<p>위치: %s</p>\n", person.photo().location()));
	}

	private void renderPhoto(StringBuffer stringBuffer, Photo photo) {
		stringBuffer.append("<div>\n");
		emitPhotoData(stringBuffer, photo);
		stringBuffer.append(String.format("<p>위치: %s</p>\n", photo.location()));
		stringBuffer.append("</div>\n");
	}

	private void listRenderPhoto(StringBuffer stringBuffer, List<Photo> photos) {
		photos.stream()
			.filter(item -> item.date().isAfter(recentDateCutoff()))
			.forEach(item -> {
				stringBuffer.append("<div>\n");
				emitPhotoData(stringBuffer, item);
				stringBuffer.append(String.format("<p>위치: %s</p>\n", item.location()));
				stringBuffer.append("</div>\n");
			});
	}

	private void emitPhotoData(StringBuffer stringBuffer, Photo photo) {
		stringBuffer.append(String.format("<p>제목: %s</p>\n", photo.title()));
		stringBuffer.append(String.format("<p>날짜: %s</p>\n", photo.date().format(DateTimeFormatter.ISO_DATE)));
	}

	private LocalDate recentDateCutoff() {
		return LocalDate.now().minusDays(1L);
	}
}
