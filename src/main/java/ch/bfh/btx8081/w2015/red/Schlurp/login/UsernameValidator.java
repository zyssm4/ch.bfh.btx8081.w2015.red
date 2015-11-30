package ch.bfh.btx8081.w2015.red.Schlurp.login;

import com.vaadin.data.Validator;

/**
 * Validates the username input of the user, if it's valid the boolean
 * isUsernameValid() turns true.
 * 
 * @author Rea
 * @version V30.11.2015
 */
public class UsernameValidator implements Validator {

	private static boolean usernameValid = false;
	private String patientOne = "Moritz";
	private String patientTwo = "Maja";
	private String exceptionRemark = "False Username";

	public void validate(Object value) throws InvalidValueException {
		if (!(value instanceof String
				&& (((String) value).equals(patientOne) || ((String) value).equals(patientTwo)))) {
			throw new InvalidValueException(exceptionRemark);
		} else {
			usernameValid = true;
		}
	}

	public static boolean isUsernameValid() {
		return usernameValid;
	}
}