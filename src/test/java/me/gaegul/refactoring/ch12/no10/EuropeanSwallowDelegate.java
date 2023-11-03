package me.gaegul.refactoring.ch12.no10;

import java.util.Map;

public class EuropeanSwallowDelegate extends SpeciesDelegate {

    public EuropeanSwallowDelegate(Map<String, String> data, Bird bird) {
        super(data, bird);
    }

    @Override
    public int airSpeedVelocity() {
        return 35;
    }
}
