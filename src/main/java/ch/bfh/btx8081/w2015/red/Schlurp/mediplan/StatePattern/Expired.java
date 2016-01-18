package ch.bfh.btx8081.w2015.red.Schlurp.mediplan.StatePattern;

import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.Medicament;

/**
 * <p>
 * The Expired extends DrugState and is one of the three states of the 
 * Statepattern.
 * </p>
 * 
 * The class has a method to get the expired style for later use on the gui
 * 
 * Aswell it has the switchState to change from Expired to Taken if the Medicament has been taken
 * 
 * * 
 * @author Mauro Tschanz
 *
 */
public class Expired extends DrugState {
	Medicament actMedi;
	String style = "expired";
	
	/**
	 * Constructor of the Expired state
	 * Needs a Medicament
	 * 
	 * @param aMedi - Medicament
	 */
	public Expired(Medicament aMedi) {
		actMedi = aMedi;
	}

	/**
	 * 
	 * Returns the Expired-Style String
	 * @param style - String
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * 
	 * Switches the State to taken from expired.
	 * Also the Date gets returned to the last time, when the Medi has been taken
	 */
	public void switchState() {
		actMedi.setToTake(actMedi.getTaken());
		actMedi.setState(new Taken(actMedi));

	}

}
