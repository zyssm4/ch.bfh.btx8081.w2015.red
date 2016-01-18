package ch.bfh.btx8081.w2015.red.Schlurp.mediplan.StatePattern;

import java.util.Date;

import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.Medicament;

/**
 * <p>
 * The Upcoming extends DrugState and is one of the three states of the
 * Statepattern.
 * </p>
 * 
 * The class has a method to get the upcoming style for later use on the gui
 * 
 * Aswell it has the switchState to change from expired to upcoming if the
 * medicament get's disgorged
 * 
 * *
 * 
 * @author Mauro Tschanz
 *
 */
public class Upcoming extends DrugState {
	Medicament actMedi;
	String style = "upcoming";

	/**
	 * Constructor of the Upcoming state Needs a Medicament
	 * 
	 * @param aMedi
	 *            - Medicament
	 */
	public Upcoming(Medicament aMedi) {
		actMedi = aMedi;

	}

	/**
	 * 
	 * Returns the Taken-Style String
	 * 
	 * @param style
	 *            - String
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * it changes from Upcoming to Taken if the medicament has been taken.
	 * Aswell the next ToTake Date gets updated and will be set to the actToTake Date + the intervall
	 */
	public void switchState() {
		int intervallTimeInHours = Integer.parseInt(actMedi.getInterval());
		actMedi.setToTake(new Date( actMedi.getToTake().getTime() + intervallTimeInHours*3600000));
		actMedi.setState(new Taken(actMedi));

	}

	/**
	 * 
	 * This method checks if the set Date of the medicament when it should be
	 * taken is after the actual date. If this is the case, the state switches
	 * to expired.
	 */
	public void checkTime() {
		Date date = new Date();
		if (actMedi.getToTake().before(date)) {
			actMedi.setState(new Expired(actMedi));
		}

	}
}
