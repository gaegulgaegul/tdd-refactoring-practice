package me.gaegul.refactoring.ch12.no10;

import java.util.Map;

public class NorwegianBlueParrotDelegate implements SpeciesDelegate {
    private int voltage;			// 	전압
    private boolean isNailed;		// 발톱을 가지고 있는지 유무

    public NorwegianBlueParrotDelegate(Map<String, String> data) {
        this.voltage = Integer.valueOf(data.getOrDefault("voltage", "0")).intValue();
        this.isNailed = Boolean.valueOf(data.getOrDefault("isNailed", "false")).booleanValue();
    }

    @Override
    public int airSpeedVelocity() {
        return this.isNailed ? 0 : 10 + this.voltage / 10;
    }
}
