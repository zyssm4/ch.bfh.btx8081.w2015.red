package ch.bfh.btx8081.w2015.red.Schlurp.mediplan.StatePattern;

import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.Medicament;

public class Taken extends DrugState {
	Medicament actMedi;
	String style = "taken";

	public Taken(Medicament aMedi) {
		actMedi = aMedi;
	}

	public String getStyle() {
		return style;
	}

	public void switchState() {
		actMedi.setState(new Upcoming(actMedi));
		actMedi.checkTime();

	}

}
