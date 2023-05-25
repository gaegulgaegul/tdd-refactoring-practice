package me.gaegul.refactoring.ch07.inline_class;

public class Shipment {
	private String shippingCompany;
	private String trackingNumber;

	public Shipment(String shippingCompany, String trackingNumber) {
		this.shippingCompany = shippingCompany;
		this.trackingNumber = trackingNumber;
	}

	public String shippingCompany() {
		return this.shippingCompany;
	}

	public void setShippingCompany(final String shippingCompany) {
		this.shippingCompany = shippingCompany;
	}

	public String trackingNumber() {
		return this.trackingNumber;
	}

	public String trackingInfo() {
		return String.format("%s: %s", shippingCompany, trackingNumber);
	}
}
