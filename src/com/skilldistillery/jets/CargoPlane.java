package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	@Override
	public void loadCargo() {
		String aircraftModel=super.getModel();
		System.out.printf("Cargo Aircraft %s is ready for loading. \n", aircraftModel);
	}
	
}
