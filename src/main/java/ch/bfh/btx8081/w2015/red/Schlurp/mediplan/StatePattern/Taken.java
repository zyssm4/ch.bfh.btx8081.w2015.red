package ch.bfh.btx8081.w2015.red.Schlurp.mediplan.StatePattern;

import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.Medicament;
/**
 * <p>
 * The Taken extends DrugState and is one of the three states of the 
 * Statepattern.
 * </p>
 * 
 * The class has a method to get the taken style for later use on the gui
 * 
 * Aswell it has the switchState to change from expired to upcoming if the medicament get's disgorged
 * 
 * * 
 * @author Mauro Tschanz
 *
 */
public class Taken extends DrugState {
	Medicament actMedi;
	String style = "taken";
	
	/**
	 * Constructor of the taken state
	 * Needs a Medicament
	 * 
	 * @param aMedi - Medicament
	 */
	public Taken(Medicament aMedi) {
		actMedi = aMedi;
	}
	

	/**
	 * 
	 * Returns the Taken-Style String
	 * @param style - String
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * it changes from Taken to Upcoming and uses afterwards the checktime Method to check if the 
	 * Medicament date is still expired.
	 */
	public void switchState() {
		actMedi.setState(new Upcoming(actMedi));
		actMedi.checkTime();

	}

}
