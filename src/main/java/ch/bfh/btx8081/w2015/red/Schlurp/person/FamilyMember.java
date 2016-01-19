/**
 * 
 */
package ch.bfh.btx8081.w2015.red.Schlurp.person;

/**
 * @author Kaspar
 *
 */
public class FamilyMember extends Person {

	private String phoneNb;

	/**
	 * Constructs a family member with name
	 * 
	 * @param name
	 *            the name
	 */
	public FamilyMember(String name) {
		super(name);
	}

	/**
	 * Constructs a complete family member
	 * 
	 * @param name
	 *            the name
	 * @param phoneNb
	 *            the phone number
	 */
	public FamilyMember(String name, String phoneNb) {
		super(name);
		this.phoneNb = phoneNb;
	}

	/**
	 * @return the phoneNb
	 */
	public String getPhoneNb() {
		return phoneNb;
	}

	/**
	 * returns the phone number of this <code>FamilyMember</codes>
	 * 
	 * @return the phoneNb
	 */
	public void setPhoneNb(String phoneNb) {
		this.phoneNb = phoneNb;
	}
}
