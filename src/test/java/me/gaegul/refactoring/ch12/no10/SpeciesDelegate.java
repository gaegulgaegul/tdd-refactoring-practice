package me.gaegul.refactoring.ch12.no10;

import java.util.Map;

public class SpeciesDelegate {

    private final Map<String, String> data;
    private final Bird bird;

    public SpeciesDelegate(Map<String, String> data, Bird bird) {
        this.data = data;
        this.bird = bird;
    }

    public String plumage() {
        if (this.bird.isEmptyPlumage()) {
            return "보통이다";
        }
        return this.bird.getPlumage();
    }

    public int airSpeedVelocity() {
        return 0;
    }

    Bird bird() {
        return this.bird;
    }
}
