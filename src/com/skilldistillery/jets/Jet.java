package com.skilldistillery.jets;

public abstract class Jet {
	private String model;
	private double speed;
	private int range;
	private long price;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Jet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	
	public void getJetInfo() {
		String output= String.format("Model: %s, Speed: %.2f mph, Range: %d miles, Price: $%d", model, speed,range,price);
		System.out.println(output);
	}
	
	public void fly() {
		double maxFlightDuration= range/speed;
		String output= String.format("Model: %s, Speed: %.2f mph, Range: %d miles, Price: $%d, Max Flight Duration: %.2fh", model, speed,range,price,maxFlightDuration);
		System.out.println(output);
	}
	public double getSpeedInMach() {
		return this.speed*0.001303;
	}
}
