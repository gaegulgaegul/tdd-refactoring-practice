package me.gaegul.refactoring.ch06.extract_function;

import java.time.LocalDate;

public class Clock {
    public static LocalDate getToday() {
        return LocalDate.now();
    }
}
