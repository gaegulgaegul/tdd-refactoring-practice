package me.gaegul.refactoring.ch10;

public class Voyage {
    private String zone;
    private int length;

    public Voyage(String zone, int length) {
        this.zone = zone;
        this.length = length;
    }

    public int length() {
        return this.length;
    }

    public String getZone() {
        return this.zone;
    }
}
