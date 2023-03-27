package me.gaegul.tdd;

import java.util.regex.Pattern;

public class PasswordMatcher {

    public static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]");
    public static final Pattern UPPER_TEXT_PATTERN = Pattern.compile("[A-Z]");
    public static final int MIN_LENGTH = 8;

    public PasswordStrength match(String password) {
        if (isEmpty(password)) {
            throw new IllegalArgumentException();
        }

        int count = 0;
        if (hasUpperText(password)) count++;
        if (isGreaterThen(password)) count++;
        if (hasNumber(password)) count++;

        return PasswordStrength.of(count);
    }

    private static boolean isEmpty(String password) {
        return password == null || "".equals(password);
    }

    private boolean isGreaterThen(String password) {
        return password.length() >= MIN_LENGTH;
    }

    private boolean hasNumber(String password) {
        return NUMBER_PATTERN.matcher(password).find();
    }

    private boolean hasUpperText(String password) {
        return UPPER_TEXT_PATTERN.matcher(password).find();
    }
}
