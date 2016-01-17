package ch.bfh.btx8081.w2015.red.Schlurp.person;

/**
 * Represents a <code>person</code> with its last name and first name.
 * 
 * @author Kaspar
 * @version V27.11.2015
 */
public class Person {
	private String lastName;
	private String firstName;

	/**
	 * Initializes an object representing a <code>Person</code>.
	 * 
	 * @param lastName
	 *            the last name
	 * @param firstName
	 *            the first name
	 */
	public Person(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}

	/**
	 * Initialize an object representing a <code>Person</code>
	 * 
	 * @param lastName
	 */
	public Person(String lastName) {
		super();
		this.lastName = lastName;
	}

	/**
	 * Returns the last name of this <code>Person</code>.
	 * 
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of this <code>Person</code>.
	 * 
	 * @param lastName
	 *            the last name to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns the first name of this <code>Person</code>.
	 * 
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of this <code>Person</code>
	 * 
	 * @param firstName
	 *            the first name to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Generated hashCode method,because only used for the Junit tests
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	/**
	 * Generated equals method, because only used for the Junit tests
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

}
