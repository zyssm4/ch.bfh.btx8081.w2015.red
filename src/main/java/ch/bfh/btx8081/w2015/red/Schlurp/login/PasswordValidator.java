package ch.bfh.btx8081.w2015.red.Schlurp.login;

import com.vaadin.data.Validator;
import com.vaadin.data.Validator.InvalidValueException;

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
