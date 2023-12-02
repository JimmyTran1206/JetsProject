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
		airField=new AirField();
	}

	
	public void cleanUp() {
		kb.close();
	}
	
	public void launch() {
		displayUserMenu();
		listFleet(airField);
		flyAllJets(airField);
		viewFastestJet(airField);
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
		fleetSize=af.getJets().size();
		if(fleetSize==0) {
			System.out.println("There is no aircraft on the field. Please add aircraft");
			return;
		}
		System.out.printf("There are %d aircrafts on the field: \n", fleetSize);
		for (int i=0;i<fleetSize; i++) {
			System.out.println("Aircraft # "+ (i+1));
			af.getJets().get(i).getJetInfo();			
		}
		System.out.println("--------------------------------------------- ");
	}
	
	public void flyAllJets(AirField af) {
		fleetSize=af.getJets().size();
		if(fleetSize==0) {
			System.out.println("There is no aircraft on the field. Please add aircraft");
			return;
		}
		System.out.printf("There are %d aircrafts ready to flight: \n", fleetSize);
		for (int i=0;i<fleetSize; i++) {
			System.out.println("Aircraft # "+ (i+1));
			af.getJets().get(i).fly();			
		}
		System.out.println("--------------------------------------------- ");
	}
	
	public void viewFastestJet(AirField af) {
		fleetSize=af.getJets().size();
		if(fleetSize==0) {
			System.out.println("There is no aircraft on the field. Please add aircraft");
			return;
		}
		double maxSpeed=0;
		int index=0;
		for (int i=0; i<fleetSize; i++) {
			double speed=af.getJets().get(i).getSpeed();
			if(speed>maxSpeed) {
				maxSpeed=speed;
				index=i;
			}
		}
		String airCraftModel= af.getJets().get(index).getModel();
		System.out.printf("The aircraft %s is the fasted with a maximum speed of %.2f mph. \n", airCraftModel, maxSpeed);
		af.getJets().get(index).getJetInfo();
		System.out.println("--------------------------------------------- ");
	}
}
