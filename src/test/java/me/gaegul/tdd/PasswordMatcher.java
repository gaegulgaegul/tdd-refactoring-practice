package me.gaegul.tdd;

import java.util.regex.Pattern;

public class PasswordMatcher {
    public PasswordStrength match(String password) {
        if (password == null || "".equals(password)) {
            throw new IllegalArgumentException();
        }
        Pattern number = Pattern.compile("[0-9]");
        Pattern upperText = Pattern.compile("[A-Z]");

        int count = 0;
        boolean isGreaterThen = password.length() >= 8;
        boolean hasNumber = number.matcher(password).find();
        boolean hasUpperText = upperText.matcher(password).find();

        if (hasUpperText) count++;
        if (isGreaterThen) count++;
        if (hasNumber) count++;

        switch (count) {
            case 3:
                return PasswordStrength.STRONG;
            case 2:
                return PasswordStrength.NORMAL;
            default:
                return PasswordStrength.WEAK;
        }
    }
}
