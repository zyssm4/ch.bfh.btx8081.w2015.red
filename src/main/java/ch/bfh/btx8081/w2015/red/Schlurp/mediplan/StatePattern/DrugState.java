package ch.bfh.btx8081.w2015.red.Schlurp.mediplan.StatePattern;

/**
 * The class represents the base of the Statepattern
 * It involves all the methods, which are used to switch state
 * <p>
 *
 * Also there is a Method to get the style of the state to show 
 * the correct Style on the GUI
 *
 * <p>
 * 
 * @author Mauro Tschanz
 *
 */

import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.Medicament;

public abstract class DrugState {

	private Medicament actMedi;
	private String style = "default";

	/**
	 * 
	 * Returns the current style of the State
	 * 
	 * @return String style
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * Switches the States from the Medicament Due the fact this is the abstract
	 * Class of the Statepattern the switch does not work and print's out ERROR
	 */
	public void switchState() {
		System.out.println("ERROR");
	
	}

	/**
	 * This Method is used to check the time if the medicament take time is
	 * overdue to the system time.
	 */
	public void checkTime() {

		System.out.println("ERROR");

	}

}
