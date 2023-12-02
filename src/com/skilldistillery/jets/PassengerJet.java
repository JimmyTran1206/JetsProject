package com.skilldistillery.jets;

public class PassengerJet extends Jet implements PassengerCarrier {
	public PassengerJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	@Override
	public void loadPassenger() {
		String aircraftModel=super.getModel();
		System.out.printf("Passenger Aircraft %s is ready for passenger boarding. \n", aircraftModel);
	}

}
