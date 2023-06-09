package me.gaegul.refactoring.ch06.extract_function;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DebtStatus {
    public String getOwing(Invoice invoice) {
        StringBuilder builder = new StringBuilder();
        builder.append(printBanner());
        int outstanding = calculateOutstanding(invoice);
        recordDueDate(invoice);
        builder.append(printDetails(invoice, outstanding));
        return builder.toString();
    }

    private int calculateOutstanding(Invoice invoice) {
        int result = 0;
        for (Order o : invoice.getOrders()) {
            result += o.getAmount();
        }
        return result;
    }

    private void recordDueDate(Invoice invoice) {
        LocalDate today = Clock.getToday();
        invoice.setDueDate(today.plusDays(30L));
    }

    private String printDetails(Invoice invoice, int outstanding) {
        return "고객명: " + invoice.getCustomer() + "\n"
                + "채무액: " + outstanding + "\n"
                + "마감일: " + invoice.getDueDate().format(DateTimeFormatter.ISO_DATE);
    }

    private String printBanner() {
        return "**********************\n"
                + "****   고객 채무   ****\n"
                + "**********************\n";
    }
}
