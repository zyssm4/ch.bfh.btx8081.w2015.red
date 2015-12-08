package ch.bfh.btx8081.w2015.red.Schlurp.mediplan.StatePattern;

import java.util.Date;

import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.Medicament;

public abstract class DrugState {

	private Medicament actMedi;
	String style = "default";
	Date systemTime;

	public String getStyle() {
		return style;
	}

	public void switchState() {
		System.out.println("ERROR");
		actMedi.setState(actMedi.getState());
	}

	public Date getSystemTime() {
		systemTime = new java.util.Date();
		return systemTime;
	}

	public void checkTime() {

		// if(this.getSystemTime().after(actMedi.getStart())){
		System.out.println("ERROR");
		// }

	}

}
