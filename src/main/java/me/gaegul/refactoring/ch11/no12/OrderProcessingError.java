package me.gaegul.refactoring.ch11.no12;

public class OrderProcessingError extends RuntimeException {
    private int errorCode;

    public OrderProcessingError(int errorCode) {
        super("주문 처리 오류: " + errorCode);
        this.errorCode = errorCode;
    }

    public String getName() {
        return "OrderProcessingError";
    }

    public int code() {
        return this.errorCode;
    }
}
