package me.gaegul.refactoring.ch06.extract_variable;

public class Order {
    private final int quantity;
    private final int itemPrice;

    public Order(int quantity, int itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    int getBasePrice() {
        return getQuantity() * getItemPrice();
    }

    double getQuantityDiscount() {
        return Math.max(0, getQuantity() - 500) * getItemPrice() * 0.05;
    }

    double getShipping() {
        return Math.min(getBasePrice() * 0.1, 100);
    }
}
