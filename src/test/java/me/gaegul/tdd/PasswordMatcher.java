package me.gaegul.tdd;

public class PasswordMatcher {
    public PasswordStrength match(String password) {
        if (password == null || "".equals(password)) {
            throw new IllegalArgumentException();
        }
        return PasswordStrength.STRONG;
    }
}
