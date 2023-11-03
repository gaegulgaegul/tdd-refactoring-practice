package me.gaegul.refactoring.ch12.no10;

import java.util.Map;

public class AfricanSwallowDelegate implements SpeciesDelegate {
    private int numberOfCocounts;

    public AfricanSwallowDelegate(Map<String, String> data) {
        this.numberOfCocounts = Integer.valueOf(data.getOrDefault("numberOfCocounts", "0")).intValue();
    }

    @Override
    public int airSpeedVelocity() {
        return 40 - 2 * this.numberOfCocounts;
    }
}
