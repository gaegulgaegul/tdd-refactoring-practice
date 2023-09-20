package me.gaegul.refactoring.ch11.no12;

public class OrderData {
	private String country;

	public OrderData(final String country) {
		this.country = country;
	}

	public String country() {
		return this.country;
	}

	@Override
	public String toString() {
		return "OrderData{" +
			"country='" + country + '\'' +
			'}';
	}
}
