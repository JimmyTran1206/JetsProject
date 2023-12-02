package com.skilldistillery.jets;

import java.util.ArrayList;

public class AirField {
	private ArrayList<Jet> jets;
	public AirField () {
		jets.add(new CargoPlane("AirBus A300", 544, 4000, 105_000_000)); //data according to Google
		jets.add(new CargoPlane("Lockheed L-100 Hercules", 355, 1535, 4_800_000)); // data according to Google
		jets.add(new FighterJet("F-35C", 1200, 1400, 75_000_000)); //data according to Google
		jets.add(new FighterJet("F-18F", 1190, 2069, 13_700_000)); //data according to Google
		jets.add(new PassengerJet("Boeing 747", 614, 8358, 418_000_000)); //data according to Google		
	}

}
