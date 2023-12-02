package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication {

	private AirField airField;
	private Scanner kb = new Scanner(System.in);
	private int fleetSize;

	public JetsApplication() {
		super();
	}

	public static void main(String[] args) {
		JetsApplication app = new JetsApplication();
		app.initialization();
		app.launch();
		app.cleanUp();
	}

	public void initialization() {
		airField = new AirField();
	}

	public void cleanUp() {
		kb.close();
	}

	public void launch() {
		displayUserMenu();
		listFleet(airField);
		flyAllJets(airField);
		viewFastestJet(airField);
		viewLongestRange(airField);
	}

	public void displayUserMenu() {
		System.out.println("=============================================");
		System.out.println("|| 1. List fleet                           ||");
		System.out.println("|| 2. Fly all jets                         ||");
		System.out.println("|| 3. View fastest jet                     ||");
		System.out.println("|| 4. View jet with longest range          ||");
		System.out.println("|| 5. Load all Cargo Jets                  ||");
		System.out.println("|| 6. Dogfight!                            ||");
		System.out.println("|| 7. Load all Passenger Jets              ||");
		System.out.println("|| 8. Add a jet to Fleet                   ||");
		System.out.println("|| 9. Remove a jet from Fleet              ||");
		System.out.println("||10. Quit                                 ||");
		System.out.println("|| Choose options 1-9 to begin             ||");
		System.out.println("=============================================");
	}

	public void listFleet(AirField af) {
		fleetSize = af.getJets().size();
		if (fleetSize == 0) {
			System.out.println("There is no aircraft on the field. Please add an aircraft.");
			return;
		}
		System.out.printf("Number of aircrafts on the field: %d \n", fleetSize);
		for (int i = 0; i < fleetSize; i++) {
			System.out.println("Aircraft # " + (i + 1));
			af.getJets().get(i).getJetInfo();
		}
		System.out.println("--------------------------------------------- ");
	}

	public void flyAllJets(AirField af) {
		fleetSize = af.getJets().size();
		if (fleetSize == 0) {
			System.out.println("There is no aircraft on the field. Please add an aircraft.");
			return;
		}
		System.out.printf("Number of aircraft ready for flight: %d \n", fleetSize);
		for (int i = 0; i < fleetSize; i++) {
			System.out.println("Aircraft # " + (i + 1));
			af.getJets().get(i).fly();
		}
		System.out.println("--------------------------------------------- ");
	}

	public void viewFastestJet(AirField af) {
		fleetSize = af.getJets().size();
		if (fleetSize == 0) {
			System.out.println("There is no aircraft on the field. Please add an aircraft.");
			return;
		}
		double maxSpeed = 0;
		for (int i = 0; i < fleetSize; i++) {
			double speed = af.getJets().get(i).getSpeed();
			if (speed > maxSpeed) {
				maxSpeed = speed;
			}
		}
		// using for loop in case more than 1 models has the same maximum speed
		for (Jet jet : af.getJets()) {
			if (jet.getSpeed() == maxSpeed) {
				String airCraftModel = jet.getModel();
				System.out.printf("The aircraft %s has the fastest speed with a maximum speed of %.2f mph. \n",
						airCraftModel, maxSpeed);
				jet.getJetInfo();
				System.out.println("--------------------------------------------- ");
			}
		}
	}

	public void viewLongestRange(AirField af) {
		fleetSize = af.getJets().size();
		if (fleetSize == 0) {
			System.out.println("There is no aircraft on the field. Please add an aircraft.");
			return;
		}
		int maxRange = 0;
		for (int i = 0; i < fleetSize; i++) {
			int range = af.getJets().get(i).getRange();
			if (range > maxRange) {
				maxRange = range;
			}
		}
		// using for loop in case more than 1 models has the same maximum speed
		for (Jet jet : af.getJets()) {
			if (jet.getRange() == maxRange) {
				String airCraftModel = jet.getModel();
				System.out.printf("The aircraft %s has the longest range with a maximum range of %d miles. \n",
						airCraftModel, maxRange);
				jet.getJetInfo();
				System.out.println("--------------------------------------------- ");
			}
		}
	}

	public void loadAllCargoJets(AirField af) {

	}

}
