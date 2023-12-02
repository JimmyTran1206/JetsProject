package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication {

	private AirField airField;
	private Scanner kb = new Scanner(System.in);

	public JetsApplication() {
		super();
	}

	public static void main(String[] args) {
		JetsApplication app = new JetsApplication();
		app.launch();
	}

	public void launch() {
		displayUserMenu();

	}

	public void displayUserMenu() {
		System.out.println("=============================================");
		System.out.println("|| 1. List fleet                           ||");
		System.out.println("|| 2. Fly all jets                         ||");
		System.out.println("|| 3. View fastest jet                     ||");
		System.out.println("|| 4. View jet with longest range          ||");
		System.out.println("|| 5. Load all Cargo Jets                  ||");
		System.out.println("|| 6. Dogfight!                            ||");
		System.out.println("|| 7. Add a jet to Fleet                   ||");
		System.out.println("|| 8. Remove a jet from Fleet              ||");
		System.out.println("|| 9. Quit                                 ||");
		System.out.println("|| Choose options 1-9 to begin             ||");
		System.out.println("=============================================");
	}

}
