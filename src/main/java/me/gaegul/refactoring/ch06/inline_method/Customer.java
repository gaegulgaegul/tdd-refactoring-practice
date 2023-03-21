package me.gaegul.refactoring.ch06.inline_method;

public class Customer {
    private final String name;
    private final String location;

    public Customer(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
