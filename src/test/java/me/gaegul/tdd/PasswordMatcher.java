package me.gaegul.tdd;

import java.util.regex.Pattern;

public class PasswordMatcher {
    public PasswordStrength match(String password) {
        if (password == null || "".equals(password)) {
            throw new IllegalArgumentException();
        }
        Pattern pattern = Pattern.compile("[0-9]");

        if (password.length() >= 8 && pattern.matcher(password).find()) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }
}
