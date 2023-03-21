package me.gaegul.refactoring.ch06.extract_function;

import java.time.LocalDate;
import java.util.List;

public class Invoice {
    private final String customer;
    private final List<Order> orders;
    private LocalDate dueDate;

    public Invoice(String customer, List<Order> orders) {
        this.customer = customer;
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getCustomer() {
        return this.customer;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }
}
