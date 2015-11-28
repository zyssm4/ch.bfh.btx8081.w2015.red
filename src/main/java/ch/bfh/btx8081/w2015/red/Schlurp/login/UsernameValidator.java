package ch.bfh.btx8081.w2015.red.Schlurp.login;

import com.vaadin.data.Validator;
import com.vaadin.data.Validator.InvalidValueException;

public class UsernameValidator implements Validator {

	private static boolean usernameValid = false;
	private static String patientOne = "Moritz";
	private static String patientTwo = "Maja";

	public void validate(Object value) throws InvalidValueException {
		if (!(value instanceof String
				&& (((String) value).equals(patientOne) || ((String) value).equals(patientTwo)))) {
			throw new InvalidValueException("False Username");
		} else {
			usernameValid = true;
		}
	}

	public static boolean isUsernameValid() {
		return usernameValid;
	}

	/*public static String getPatientOne() {
		return patientOne;
	}

	public static String getPatientTwo() {
		return patientTwo;
	}*/
}