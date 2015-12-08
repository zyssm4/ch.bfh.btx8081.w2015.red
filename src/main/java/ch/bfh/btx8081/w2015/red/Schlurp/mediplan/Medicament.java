/**
 * 
 */
package ch.bfh.btx8081.w2015.red.Schlurp.mediplan;

import java.util.Date;

import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.StatePattern.*;

/**
 * @author Kaspar
 * @version V07.12.2015
 *
 */
public class Medicament {


	private String name;
	private int[] dose = new int[4];
	private int interval;
	private Date start;
	private Date end;
	private DrugState actState = new Upcoming(this);

	/**
	 * @param name 
	 * 
	 * 
	 */
	public Medicament(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @param name
	 * @param dose1
	 * @param dose2
	 * @param dose3
	 * @param dose4
	 * @param interval
	 * @param start
	 * @param end
	 */
	public Medicament(String name, int dose1, int dose2, int dose3, int dose4, int interval, Date start, Date end){
		this.name = name;
		dose[0] = dose1;
		dose[1] = dose2;
		dose[2] = dose3;
		dose[3] = dose4;
		this.interval = interval;
		this.start = start;
		this.end = end;
	}
	
	//---------------------------------------------------------------//
	//--------------------START-GETTER-SECTION-----------------------//
	//---------------------------------------------------------------//

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the dose
	 */
	public int[] getDose() {
		return dose;
	}
	/**
	 * 
	 * @return
	 */
	public int getDoseMorning(){
		return dose[0];
	}
	/**
	 * 
	 * @return
	 */
	public int getDoseMidday(){
		return dose[1];
	}
	/**
	 * 
	 * @return
	 */
	public int getDoseEvening(){
		return dose[2];
	}
	/**
	 * 
	 * @return
	 */
	public int getDoseNight(){
		return dose[3];
	}
	/**
	 * @param dose the dose to set
	 */
	
	//---------------------------------------------------------------//
	//--------------------START-SETTER-SECTION-----------------------//
	//---------------------------------------------------------------//

	public void setDose(int[] dose) {
		this.dose = dose;
	}
	/**
	 * @return the interval
	 */
	public int getInterval() {
		return interval;
	}
	/**
	 * @param interval the interval to set
	 */
	public void setInterval(int interval) {
		this.interval = interval;
	}
	/**
	 * @return the start
	 */
	public Date getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(Date start) {
		this.start = start;
	}
	/**
	 * @return the end
	 */
	public Date getEnd() {
		return end;
	}
	/**
	 * @param end the end to set
	 */
	public void setEnd(Date end) {
		this.end = end;
	}
	
	//---------------------------------------------------------------//
	//--------------------StatePattern-Functions---------------------//
	//---------------------------------------------------------------//

	public void setState(DrugState aState){
		actState = aState;
	}
	public DrugState getState(){
		return actState;
	}
	public void switchState(){
		actState.switchState();
	}
	public void checkTime(){
		actState.checkTime();
	}
	public String getStyle(){
		return actState.getStyle();
	}
}
