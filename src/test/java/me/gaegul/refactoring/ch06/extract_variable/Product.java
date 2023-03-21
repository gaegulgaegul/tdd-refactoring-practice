package me.gaegul.refactoring.ch06.extract_variable;

public class Product {
    public double price(Order order) {
        int basePrice = order.getQuantity() * order.getItemPrice();
        return basePrice
                - Math.max(0, order.getQuantity() - 500) * order.getItemPrice() * 0.05
                + Math.min(basePrice * 0.1, 100);
    }
}
