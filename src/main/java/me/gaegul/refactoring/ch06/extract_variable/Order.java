package me.gaegul.refactoring.ch06.extract_variable;

public class Order {
    private final int quantity;
    private final int itemPrice;

    public Order(int quantity, int itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    int getBasePrice() {
        return quantity * itemPrice;
    }

    double getQuantityDiscount() {
        return Math.max(0, quantity - 500) * itemPrice * 0.05;
    }

    double getShipping() {
        return Math.min(getBasePrice() * 0.1, 100);
    }

    public double price() {
        return getBasePrice() - getQuantityDiscount() + getShipping();
    }
}
