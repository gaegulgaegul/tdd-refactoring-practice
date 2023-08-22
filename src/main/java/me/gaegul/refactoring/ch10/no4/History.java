package me.gaegul.refactoring.ch10.no4;

public class History {

    private String zone;
    private int profit;

    public History(String zone, int profit) {
        this.zone = zone;
        this.profit = profit;
    }

    public int getProfit() {
        return this.profit;
    }

    public String getZone() {
        return this.zone;
    }
}
