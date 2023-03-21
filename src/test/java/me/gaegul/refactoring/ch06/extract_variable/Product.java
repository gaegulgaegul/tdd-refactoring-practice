package me.gaegul.refactoring.ch06.extract_variable;

public class Product {
    public double price(Order order) {
        return order.getBasePrice() - order.getQuantityDiscount() + order.getShipping();
    }

}
