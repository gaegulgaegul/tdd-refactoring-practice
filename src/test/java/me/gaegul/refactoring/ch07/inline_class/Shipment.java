package me.gaegul.refactoring.ch07.inline_class;

public class Shipment {
	private TrackingInformation trackingInformation;

	public Shipment(TrackingInformation trackingInformation) {
		this.trackingInformation = trackingInformation;
	}

	public TrackingInformation trackingInformation() {
		return this.trackingInformation;
	}

	public void setTrackingInformation(final TrackingInformation trackingInformation) {
		this.trackingInformation = trackingInformation;
	}

	public String trackingInfo() {
		return this.trackingInformation.display();
	}
}
