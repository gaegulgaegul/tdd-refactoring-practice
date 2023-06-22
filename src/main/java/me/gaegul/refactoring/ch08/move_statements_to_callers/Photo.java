package me.gaegul.refactoring.ch08.move_statements_to_callers;

import java.time.LocalDate;

public class Photo {
	private String title;
	private LocalDate date;
	private String location;

	public Photo(final String title, final LocalDate date, final String location) {
		this.title = title;
		this.date = date;
		this.location = location;
	}

	public String title() {
		return this.title;
	}

	public LocalDate date() {
		return this.date;
	}

	public String location() {
		return this.location;
	}
}
