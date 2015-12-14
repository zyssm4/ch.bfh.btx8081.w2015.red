/**
 * 
 */
package ch.bfh.btx8081.w2015.red.Schlurp.mediplan;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.NativeSelect;

import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.StatePattern.*;

/**
 * @author Kaspar
 * @version V07.12.2015
 *
 */
public class Medicament {

	static final AtomicLong NEXT_ID = new AtomicLong(0);
	// ID for the next Medicament, if retrieved via getIdToSet it gets
	// incremented by one
	final long idToSet = NEXT_ID.getAndIncrement();
	// Actual ID of the Medicament
	private long mediID;
	private String name;
	private String interval;
	private Date start;
	private Date end;
	private DrugState actState = new Upcoming(this);
	private Date taken;
	private Date toTake;

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
	 * @param start
	 * @param end
	 */
	public Medicament(String name, String Intervall, Date start, Date end) {
		mediID = getIdToSet();
		this.name = name;
		this.interval = Intervall;
		this.start = start;
		this.end = end;

	}

	// ---------------------------------------------------------------//
	// --------------------START-GETTER-SECTION-----------------------//
	// ---------------------------------------------------------------//
	public long getIdToSet() {
		return idToSet;
	}

	public long getMediID() {
		return mediID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	// ---------------------------------------------------------------//
	// --------------------START-SETTER-SECTION-----------------------//
	// ---------------------------------------------------------------//

	/**
	 * @return the interval
	 */
	public String getInterval() {
		return interval;
	}

	/**
	 * @param interval
	 *            the interval to set
	 */
	public void setInterval(String interval) {
		this.interval = interval;
	}

	/**
	 * @return the start
	 */
	public Date getStart() {
		return start;
	}

	/**
	 * @param start
	 *            the start to set
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
	 * @param end
	 *            the end to set
	 */
	public void setEnd(Date end) {
		this.end = end;
	}

	// ---------------------------------------------------------------//
	// --------------------StatePattern-Functions---------------------//
	// ---------------------------------------------------------------//

	public void setState(DrugState aState) {
		actState = aState;
	}

	public DrugState getState() {
		return actState;
	}

	public void switchState() {
		actState.switchState();
	}

	public void checkTime() {
		actState.checkTime();
	}

	public String getStyle() {
		return actState.getStyle();
	}

	public Date getTaken() {
		return taken;
	}

	public void setTaken(Date taken) {
		this.taken = taken;
	}

	public Date getToTake() {
		return toTake;
	}

	public void setToTake(Date toTake) {
		this.toTake = toTake;
	}

	@Override
	public String toString() {
		return "Medicament [name=" + name + ", interval=" + interval
				+ ", start=" + start + ", end=" + end + ", actState="
				+ actState + ", taken=" + taken + ", toTake=" + toTake + "]";
	}

}
