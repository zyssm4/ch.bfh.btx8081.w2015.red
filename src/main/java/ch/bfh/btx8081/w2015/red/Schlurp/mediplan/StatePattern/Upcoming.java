package ch.bfh.btx8081.w2015.red.Schlurp.mediplan.StatePattern;

import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.Medicament;

public class Upcoming extends DrugState {
	Medicament actMedi;
	String style = "upcoming";
	
	public Upcoming(Medicament aMedi){
		actMedi = aMedi;
	
	}

	public String getStyle(){
		return style;
	}
	
	public void switchState(){

		actMedi.setState(new Taken(actMedi));
		
	}
	public void checkTime(){
		//if(this.getSystemTime().after(actMedi.getStart())){
			actMedi.setState(new Expired(actMedi));
		//}

	}
	
}
