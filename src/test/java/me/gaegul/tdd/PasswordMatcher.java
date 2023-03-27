package me.gaegul.tdd;

import java.util.regex.Pattern;

public class PasswordMatcher {
    public PasswordStrength match(String password) {
        if (password == null || "".equals(password)) {
            throw new IllegalArgumentException();
        }
        Pattern number = Pattern.compile("[0-9]");
        Pattern upperText = Pattern.compile("[A-Z]");

        boolean isGreaterThen = password.length() >= 8;
        boolean hasNumber = number.matcher(password).find();
        boolean hasUpperText = upperText.matcher(password).find();

        if (isGreaterThen && hasNumber) {
            return PasswordStrength.NORMAL;
        }
        if (hasNumber && hasUpperText) {
            return PasswordStrength.NORMAL;
        }
        if (isGreaterThen && hasUpperText) {
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
    }
}
