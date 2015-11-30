package ch.bfh.btx8081.w2015.red.Schlurp.login;

import com.vaadin.data.Validator;


/**
 * Validates the password input of the user, if it's valid the boolean
 * isPasswordValid() turns true.
 * 
 * @author Rea
 * @version V30.11.2015
 */
public class PasswordValidator implements Validator {

	private static boolean passwordValid = false;
	private String password = "schlurp";

	public void validate(Object value) throws InvalidValueException {
		if (!(value instanceof String && ((String) value).equals(password))) {
			throw new InvalidValueException("False Username");
		} else {
			passwordValid = true;
		}

	}

	public static boolean isPasswordValid() {
		return passwordValid;
	}

}
