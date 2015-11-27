package ch.bfh.btx8081.w2015.red.Schlurp.person;
/**
 * A <code>Doctor</code> object represents a doctor (abstraction) with its
 * following data (name and phone number).
 * <p>
 * Note: The input data are not validated. 
 * 
 * @author Kaspar
 * @version V27.11.2015
 */
public class Doctor extends Person{
	
	private String phoneNb;

	/**
	 * Constructs a doctor with its name
	 * 
	 * @param name
	 * 			the name
	 * 
	 */
	public Doctor(String name) {
		super(name);
	}

	/**
	 * Constructs a doctor
	 * 
	 * @param name
	 * 			the name
	 * @param phoneNb
	 * 			the phone number
	 */
	public Doctor(String name, String telNb) {
		super(name);
		this.phoneNb = telNb;
	}

	/**
	 * returns the phone number of this <code>Doctor</codes>
	 * 
	 * @return the phoneNb
	 */
	public String getPhoneNb() {
		return phoneNb;
	}

	/**
	 * sets the phone number of this <code>Doctor</codes>
	 * @param phoneNb
	 * 			the phone number to set
	 */
	public void setPhoneNb(String phoneNb) {
		this.phoneNb = phoneNb;
	}
}
