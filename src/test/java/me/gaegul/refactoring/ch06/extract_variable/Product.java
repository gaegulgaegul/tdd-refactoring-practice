package me.gaegul.refactoring.ch06.extract_variable;

public class Product {
    public double price(Order order) {
        throw new UnsupportedOperationException("Product::price");
    }
}
