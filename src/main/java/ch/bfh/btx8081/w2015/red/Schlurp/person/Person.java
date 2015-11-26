package ch.bfh.btx8081.w2015.red.Schlurp.person;

/**
 * Represents a <code>person</code> with its last name and first name.
 * 
 * @author Kaspar
 * @version V26.11.2015
 */
public class Person {
	private String lastName;
	private String firstName;

	/**
	 * Initializes an object representing a <code>person</code>.
	 * 
	 * @param lastName
	 * 			the last name
	 * @param firstName
	 * 			the first name
	 */
	public Person(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}

	/**
	 * Returns the last name of this <code>person</code>.
	 * 
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of this <code>person</code>.
	 * @param lastName
	 *            the last name to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns the first name of this <code>person</code>.
	 * 
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of this <code>person</code>
	 * @param firstName
	 *            the first name to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
