package me.gaegul.refactoring.ch07.inline_class;

public class TrackingInformation {
	private String shippingCompany;
	private String trackingNumber;

	public TrackingInformation(String shippingCompany, String trackingNumber) {
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

	public void setTrackingNumber(final String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String display() {
		return String.format("%s: %s", shippingCompany, trackingNumber);
	}
}
