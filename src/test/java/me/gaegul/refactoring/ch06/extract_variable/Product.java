package me.gaegul.refactoring.ch06.extract_variable;

public class Product {
    public double price(Order order) {
        int basePrice = getBasePrice(order);
        double quantityDiscount = getQuantityDiscount(order);
        double shipping = getShipping(order);
        return basePrice - quantityDiscount + shipping;
    }

    private double getShipping(Order order) {
        return Math.min(getBasePrice(order) * 0.1, 100);
    }

    private double getQuantityDiscount(Order order) {
        return Math.max(0, order.getQuantity() - 500) * order.getItemPrice() * 0.05;
    }

    private int getBasePrice(Order order) {
        return order.getQuantity() * order.getItemPrice();
    }
}
