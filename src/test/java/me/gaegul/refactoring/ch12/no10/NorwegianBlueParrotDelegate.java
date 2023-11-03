package me.gaegul.refactoring.ch12.no10;

import java.util.Map;

public class NorwegianBlueParrotDelegate extends SpeciesDelegate {

    private int voltage;			// 	전압
    private boolean isNailed;		// 발톱을 가지고 있는지 유무

    public NorwegianBlueParrotDelegate(Map<String, String> data, Bird bird) {
        super(data, bird);
        this.voltage = Integer.valueOf(data.getOrDefault("voltage", "0")).intValue();
        this.isNailed = Boolean.valueOf(data.getOrDefault("isNailed", "false")).booleanValue();
    }

    @Override
    public int airSpeedVelocity() {
        return this.isNailed ? 0 : 10 + this.voltage / 10;
    }

    @Override
    public String plumage() {
        if (this.voltage > 100) return "그을렸다";
        if (super.bird().isEmptyPlumage()) return "예쁘다";
        return super.bird().getPlumage();
    }
}
