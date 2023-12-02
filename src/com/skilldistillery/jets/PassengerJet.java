package com.skilldistillery.jets;

public class PassengerJet extends Jet implements PassengerCarrier {
	public PassengerJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	public void loadPassenger() {
		
	}

}
