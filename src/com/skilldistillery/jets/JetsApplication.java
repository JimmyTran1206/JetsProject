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
		displayMainMenu();
		promptUserInputMainMenu();
	}

	public void displayMainMenu() {
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
		System.out.println("||Make choices 1-10 or press ? for menu    ||");
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
		int cargoFleetSize = 0;
		// find the number of cargo jets
		for (Jet jet : af.getJets()) {
			if (jet instanceof CargoPlane) {
				cargoFleetSize++;
			}
		}
		if (cargoFleetSize == 0) {
			System.out.println("There is no Cargo Aircraft on the field. Please add a Cargo Aircraft.");
			return;
		}
		for (Jet jet : af.getJets()) {
			if (jet instanceof CargoPlane) {
				((CargoPlane) jet).loadCargo();
			}
		}
		System.out.println("--------------------------------------------- ");
	}

	public void dogFight(AirField af) {
		int fighterFleetSize = 0;
		// find the number of fighter jets
		for (Jet jet : af.getJets()) {
			if (jet instanceof FighterJet) {
				fighterFleetSize++;
			}
		}
		if (fighterFleetSize == 0) {
			System.out.println("There is no Fighter Aircraft on the field. Please add a Fighter Aircraft.");
			return;
		}
		for (Jet jet : af.getJets()) {
			if (jet instanceof FighterJet) {
				((FighterJet) jet).fight();
			}
		}
		System.out.println("--------------------------------------------- ");
	}

	public void loadAllPassenger(AirField af) {
		int passengerFleetSize = 0;
		// find the number of passenger jets
		for (Jet jet : af.getJets()) {
			if (jet instanceof PassengerJet) {
				passengerFleetSize++;
			}
		}
		if (passengerFleetSize == 0) {
			System.out.println("There is no Passenger Aircraft on the field. Please add a Passenger Aircraft.");
			return;
		}
		for (Jet jet : af.getJets()) {
			if (jet instanceof PassengerJet) {
				((PassengerJet) jet).loadPassenger();
			}
		}
		System.out.println("--------------------------------------------- ");
	}

	public void promptUserInputMainMenu() {
		System.out.print("Select your choice: ");
		String userChoice;
		while (true) {
			userChoice = kb.nextLine();
			switch (userChoice) {
			case "?":
			case "/":
				displayMainMenu();
				System.out.print("Select your choice: ");
				break;
			case "1":
				System.out.println("You have chosen to view the aircaft: ");
				listFleet(airField);
				System.out.print("Select another choice, press 10 to exit or press ? for main menu: ");
				break;
			case "2":
				System.out.println("You have chosen to fly the aircaft: ");
				flyAllJets(airField);
				System.out.print("Select another choice, press 10 to exit or press ? for main menu: ");
				break;
			case "3":
				System.out.println("You have chosen to view the fastest aircaft: ");
				viewFastestJet(airField);
				System.out.print("Select another choice, press 10 to exit or press ? for main menu: ");
				break;
			case "4":
				System.out.println("You have chosen to view the aircaft with the longest range: ");
				viewLongestRange(airField);
				System.out.print("Select another choice, press 10 to exit or press ? for main menu: ");
				break;
			case "5":
				System.out.println("You have chosen to load all Cargo aircraft: ");
				loadAllCargoJets(airField);
				System.out.print("Select another choice, press 10 to exit or press ? for main menu: ");
				break;
			case "6":
				System.out.println("You have chosen to make Fighter Aircraft kombat-ready: ");
				dogFight(airField);
				System.out.print("Select another choice, press 10 to exit or press ? for main menu: ");
				break;
			case "7":
				System.out.println("You have chosen to load all Passenger Aircraft: ");
				loadAllPassenger(airField);
				System.out.print("Select another choice, press 10 to exit or press ? for main menu: ");
				break;
			case "8":
				System.out.print("Select another choice, press 10 to exit or press ? for main menu: ");
				break;
			case "10":
				System.out.println("You have chosen to quit the progrmam. \n  See you again! \n    Exiting...");
				return;
			default:
				System.out.print("Invalid choice. Please select 1-10 or press ? for main menu: ");
			}
		}

	}

	public void displayJetSubMenu() {
		System.out.println("=============================================");
		System.out.println("|| 1. Cargo Aircraft                       ||");
		System.out.println("|| 2. Fighter Aircraft                     ||");
		System.out.println("|| 3. Passenger Aircraft                   ||");
		System.out.println("|| 4. Return to main                       ||");
		System.out.println("||Make choices 1-4 or press ? for menu     ||");
		System.out.println("=============================================");
	}

}
