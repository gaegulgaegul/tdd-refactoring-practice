package me.gaegul.refactoring.ch06.inline_method;

import java.util.ArrayList;
import java.util.List;

public class CustomerReport {
    public List<List<String>> reportLines(Customer aCustomer) {
        List<List<String>> lines = new ArrayList<>();
        lines.add(List.of("name", aCustomer.getName()));
        gatherCustomerData(lines, aCustomer);
        return lines;
    }

    private void gatherCustomerData(List<List<String>> lines, Customer aCustomer) {
        lines.add(List.of("location", aCustomer.getLocation()));
    }
}
