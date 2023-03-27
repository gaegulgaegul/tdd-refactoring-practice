package me.gaegul.tdd;

import java.util.regex.Pattern;

public class PasswordMatcher {
    public PasswordStrength match(String password) {
        if (password == null || "".equals(password)) {
            throw new IllegalArgumentException();
        }
        Pattern number = Pattern.compile("[0-9]");
        Pattern upperText = Pattern.compile("[A-Z]");

        if (password.length() >= 8 && number.matcher(password).find()) {
            return PasswordStrength.NORMAL;
        }
        if (number.matcher(password).find() && upperText.matcher(password).find()) {
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
    }
}
