package ch.bfh.btx8081.w2015.red.Schlurp.person;
/**
 * A <code>Doctor</code> object represents a doctor (abstraction) with its
 * following data (name, first name and phone number).
 * <p>
 * Note: The input data are not validated. 
 * 
 * @author Kaspar
 * @version V26.11.2015
 */
public class Doctor extends Person{
	
	private long phoneNb;

	/**
	 * Constructs a doctor with name and first name
	 * 
	 * @param lastName
	 * 			the last name
	 * @param firstName
	 * 			the first name
	 */
	public Doctor(String lastName, String firstName) {
		super(lastName, firstName);
	}

	/**
	 * Constructs a complete doctor
	 * @param lastName
	 * 			the last name
	 * @param firstName
	 * 			the first name
	 * @param phoneNb
	 * 			the phone number
	 */
	public Doctor(String lastName, String firstName, long telNb) {
		super(lastName, firstName);
		this.phoneNb = telNb;
	}

	/**
	 * returns the phone number of this <code>Doctor</codes>
	 * 
	 * @return the phoneNb
	 */
	public long getTelNb() {
		return phoneNb;
	}

	/**
	 * sets the phone number of this <code>Doctor</codes>
	 * @param phoneNb
	 * 			the phone number to set
	 */
	public void setTelNb(long phoneNb) {
		this.phoneNb = phoneNb;
	}

}
