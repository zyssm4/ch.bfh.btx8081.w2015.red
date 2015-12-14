package ch.bfh.btx8081.w2015.red.Schlurp.mediplan.StatePattern;


import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.Medicament;

public abstract class DrugState {

	private Medicament actMedi;
	private String style = "default";

	public String getStyle() {
		return style;
	}

	public void switchState() {
		System.out.println("ERROR");
		actMedi.setState(actMedi.getState());
	}


	public void checkTime() {
		
	System.out.println("ERROR");

	}

}
