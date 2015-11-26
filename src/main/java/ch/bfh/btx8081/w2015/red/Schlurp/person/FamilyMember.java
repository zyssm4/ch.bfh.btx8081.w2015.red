/**
 * 
 */
package ch.bfh.btx8081.w2015.red.Schlurp.person;

/**
 * @author Kaspar
 *
 */
public class FamilyMember extends Person {

	private long phoneNb;
	/**
	 * Constructs a family member with name and first name
	 * 
	 * @param lastName
	 * 			the last name
	 * @param firstName
	 * 			the first name
	 */
	public FamilyMember(String lastName, String firstName) {
		super(lastName, firstName);
	}
	
	/**
	 * Constructs a complete family member
	 * 
	 * @param lastName
	 * 			the last name
	 * @param firstName
	 * 			the first name
	 * @param phoneNb
	 * 			the phone number
	 */
	public FamilyMember(String lastName, String firstName, long phoneNb) {
		super(lastName, firstName);
		this.phoneNb = phoneNb;
	}

	/**
	 * @return the phoneNb
	 */
	public long getPhoneNb() {
		return phoneNb;
	}
	
	/**
	 * returns the phone number of this <code>FamilyMember</codes>
	 * 
	 * @return the phoneNb
	 */
	public void setPhoneNb(long phoneNb) {
		this.phoneNb = phoneNb;
	}
}
