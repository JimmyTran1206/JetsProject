package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	@Override
	public void fight() {
		String aircraftModel=super.getModel();
		System.out.printf("Fighter Aircraft %s is armed and ready for combat! \n", aircraftModel);
	}
	
}
