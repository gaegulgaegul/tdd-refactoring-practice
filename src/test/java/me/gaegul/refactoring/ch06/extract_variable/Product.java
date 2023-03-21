package me.gaegul.refactoring.ch06.extract_variable;

public class Product {
    public double price(Order order) {
        int basePrice = order.getBasePrice();
        double quantityDiscount = order.getQuantityDiscount();
        double shipping = order.getShipping();
        return basePrice - quantityDiscount + shipping;
    }

}
