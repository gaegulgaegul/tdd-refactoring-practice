package me.gaegul.refactoring.ch08.move_statements_to_callers;

import java.util.List;

public class Person {
	private String name;
	private Photo photo;

	public Person(final String name, final Photo photo) {
		this.name = name;
		this.photo = photo;
	}

	public String name() {
		return this.name;
	}

	public Photo photo() {
		return this.photo;
	}
}
