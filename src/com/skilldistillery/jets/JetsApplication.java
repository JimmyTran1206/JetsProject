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
				System.out.println("You have chosen to view all aircafts: ");
				listFleet(airField);
				System.out.print("Select another choice, press 10 to exit or press ? for main menu: ");
				break;
			case "2":
				System.out.println("You have chosen to fly all aircafts: ");
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
				System.out.println("You have chosen to load all Cargo aircrafts: ");
				loadAllCargoJets(airField);
				System.out.print("Select another choice, press 10 to exit or press ? for main menu: ");
				break;
			case "6":
				System.out.println("You have chosen to make all Fighter Aircrafts kombat-ready: ");
				dogFight(airField);
				System.out.print("Select another choice, press 10 to exit or press ? for main menu: ");
				break;
			case "7":
				System.out.println("You have chosen to load all Passenger Aircrafts: ");
				loadAllPassenger(airField);
				System.out.print("Select another choice, press 10 to exit or press ? for main menu: ");
				break;
			case "8":
				System.out.println("You have chosen to add a new aircraft to your fleet: ");
				addNewJetProcedure(airField);
				System.out.print("Select another choice, press 10 to exit or press ? for main menu: ");
				break;
			case "9":
				System.out.println("You have chosen to remove an aircraft to your fleet: ");
				removeJetProcedure(airField);
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

	public void displayMainMenu() {
		System.out.println("==================================================");
		System.out.println("|| 1. List fleet                                ||");
		System.out.println("|| 2. Fly all jets                              ||");
		System.out.println("|| 3. View fastest jet                          ||");
		System.out.println("|| 4. View jet with longest range               ||");
		System.out.println("|| 5. Load all Cargo Jets                       ||");
		System.out.println("|| 6. Dogfight!                                 ||");
		System.out.println("|| 7. Load all Passenger Jets                   ||");
		System.out.println("|| 8. Add a jet to Fleet                        ||");
		System.out.println("|| 9. Remove a jet from Fleet                   ||");
		System.out.println("||10. Quit                                      ||");
		System.out.println("||Make choices 1-10 or press ? for main menu.   ||");
		System.out.println("==================================================");
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

	public void displayJetSubMenu() {
		System.out.println("=============================================");
		System.out.println("|| Adding an aircraft to the fleet:        ||");
		System.out.println("|| 1. Cargo Aircraft                       ||");
		System.out.println("|| 2. Fighter Aircraft                     ||");
		System.out.println("|| 3. Passenger Aircraft                   ||");
		System.out.println("|| 4. Return to main menu                  ||");
		System.out.println("||Make choices 1-3.                        ||");
		System.out.println("||Press 4 or ? for returning to main menu  ||");
		System.out.println("=============================================");
	}

	private boolean isValidNumericInput(String input, String numType) {
		// check if a string is a valid numeric input of type int, long, double
		switch (numType) {
		case "int":
			try {
				int x = Integer.parseInt(input);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		case "long":
			try {
				long x = Long.parseLong(input);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		case "double":
			try {
				double x = Double.parseDouble(input);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		default:
			return false;
		}
	}

	private String promptEnter(String description) {
		// Prompt the user to enter model/speed/range/price, check type, return a valid
		// string value/ cancel/ or prompt the user until they input the correct one
		while (true) {
			System.out.printf("Enter the aircraft %s: ", description);
			String userInput = kb.nextLine();
			if (userInput.toLowerCase().equals("cancel")) {
				return "cancel";
			}
			switch (description) {
			case "model":
				return userInput;
			case "speed":
				if (isValidNumericInput(userInput, "double")) {
					return userInput;
				} else {
					System.out.println("Invalid value for aircraft speed. Please try again.");
					break;
				}
			case "range":
				if (isValidNumericInput(userInput, "int")) {
					return userInput;
				} else {
					System.out.println("Invalid value for aircraft range. Please try again.");
					break;
				}
			case "price":
				if (isValidNumericInput(userInput, "long")) {
					return userInput;
				} else {
					System.out.println("Invalid value for aircraft price. Please try again.");
					break;
				}

			}
		}
	}

	public boolean addNewJet(String jetType, AirField af) {
		System.out.printf("Add a %s Aircraft to the fleet... \n", jetType);
		System.out.println("Type \"cancel\" anytime you change your mind...");
		String model;
		double speed;
		int range;
		long price;
		String userInput = "";

		// prompt model
		userInput = promptEnter("model");
		if (userInput.equals("cancel")) {
			return false;
		} else {
			model = userInput;
		}

		// prompt speed
		userInput = promptEnter("speed");
		if (userInput.equals("cancel")) {
			return false;
		} else {
			speed = Double.parseDouble(userInput);
		}

		// prompt range
		userInput = promptEnter("range");
		if (userInput.equals("cancel")) {
			return false;
		} else {
			range = Integer.parseInt(userInput);
		}

		// prompt price
		userInput = promptEnter("price");
		if (userInput.equals("cancel")) {
			return false;
		} else {
			price = Long.parseLong(userInput);
		}

		switch (jetType) {
		case "Cargo":
			CargoPlane cp = new CargoPlane(model, speed, range, price);
			af.getJets().add(cp);
			return true;
		case "Fighter":
			FighterJet fj = new FighterJet(model, speed, range, price);
			af.getJets().add(fj);
			return true;
		case "Passenger":
			PassengerJet pj = new PassengerJet(model, speed, range, price);
			af.getJets().add(pj);
			return true;
		default:
			return false;
		}

	}

	public void addNewJetProcedure(AirField af) {
		String userInput;
		boolean newAirCraftIsAdded;
		while (true) {
			displayJetSubMenu();
			System.out.print("Please select your choice: ");
			userInput = kb.nextLine();
			switch (userInput) {
			case "1":
				newAirCraftIsAdded = addNewJet("Cargo", af);
				if (!newAirCraftIsAdded) {
					System.out.println("Cancel adding new aircraft...");
				} else {
					System.out.println("A new Cargo Aircraft has been added to your fleet");
				}
				break;
			case "2":
				newAirCraftIsAdded = addNewJet("Fighter", af);
				if (!newAirCraftIsAdded) {
					System.out.println("Cancel adding new aircraft...");
				} else {
					System.out.println("A new Fighter Aircraft has been added to your fleet");
				}
				break;
			case "3":
				newAirCraftIsAdded = addNewJet("Passenger", af);
				if (!newAirCraftIsAdded) {
					System.out.println("Cancel adding new aircraft...");
				} else {
					System.out.println("A new Passenger Aircraft has been added to your fleet");
				}
				break;
			case "?":
			case "/":
			case "4":
				System.out.println("Returning to main menu...");
				displayMainMenu();
				return;
			default:
				System.out.println("Invalid input. Please select 1-4 or press ? for main menu");
			}
		}
	}

	public void removeJetProcedure(AirField af) {
		if (af.getJets().size() == 0) {
			System.out.println("There is no aircraft on the field. Please add new aircraft");
			return;
		}
		// display aircraft for removal:
		fleetSize = af.getJets().size();
		System.out.println("Aircrafts in your field:");
		System.out.println("------------------------");
		for (int i = 0; i < fleetSize; i++) {
			String output = String.format("%3d. %s", (i + 1), af.getJets().get(i).getModel());
			System.out.println(output);
		}
		System.out.println("------------------------");
		System.out.print("Select an aircraft number to remove or type \"cancel\": ");
		int jetToRemove = 0;
		// validate input
		while (true) {
			String userInput = kb.nextLine();
			if(userInput.equals("cancel")) {
				System.out.println("Cancel removing jet...");
				displayMainMenu();
				return;
			}
			boolean isNumericInput = isValidNumericInput(userInput, "int"); // check if input is an integer
			if (!isNumericInput || Integer.parseInt(userInput) < 1 || Integer.parseInt(userInput) > fleetSize) {
				System.out.print("Invalid input. Please enter an integer less than or equal to " + fleetSize + " :");
				continue;
			} else {
				jetToRemove = Integer.parseInt(userInput);
				break;
			}
		}
		String removedJetModel= af.getJets().remove(jetToRemove-1).getModel();
		System.out.printf("Remove aircraft %s from your fleet. \n", removedJetModel);
	}

// end of the class,do not go pass this point
}
