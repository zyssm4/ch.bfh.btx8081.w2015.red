package ch.bfh.btx8081.w2015.red.Schlurp.mediplan.StatePattern;

import java.util.Date;

import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.Medicament;

public abstract class DrugState {
	
	private Medicament actMedi;
	String style = "default";
	String actTime;
	Date systemTime;

	public String getStyle() {
		return style;
	}

	public void switchState(DrugState aState) {
		actMedi.setState(aState);
	}
	public Date getSystemTime(){
		systemTime = new java.util.Date();
		return systemTime;
	}

}
