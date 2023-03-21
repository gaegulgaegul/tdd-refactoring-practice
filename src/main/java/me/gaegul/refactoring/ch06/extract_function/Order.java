package me.gaegul.refactoring.ch06.extract_function;

public class Order {
    private int amount;

    public Order(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }
}
