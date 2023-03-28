package me.gaegul.tdd;

public enum PasswordStrength {
    NORMAL, WEAK, STRONG;

    static PasswordStrength of(int count) {
        switch (count) {
            case 3:
                return STRONG;
            case 2:
                return NORMAL;
            case 1:
                return WEAK;
            default:
                throw new NotMatchPasswordException();
        }
    }
}
