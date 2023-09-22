package me.gaegul.refactoring.ch11.no12;

public class ErrorStatus {
	private final OrderData order;
	private final int status;

	public ErrorStatus(final OrderData order, final int status) {
		this.order = order;
		this.status = status;
	}

	public OrderData order() {
		return this.order;
	}

	public int status() {
		return this.status;
	}

	@Override
	public String toString() {
		return "ErrorStatus{" +
			"order=" + order +
			", status=" + status +
			'}';
	}
}
