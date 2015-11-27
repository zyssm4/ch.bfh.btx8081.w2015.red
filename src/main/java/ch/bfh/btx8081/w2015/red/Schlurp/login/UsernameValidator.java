package ch.bfh.btx8081.w2015.red.Schlurp.login;

import com.vaadin.data.Validator;
import com.vaadin.data.Validator.InvalidValueException;

public class UsernameValidator implements Validator {

	public void validate(Object value) throws InvalidValueException {
		if (!(value instanceof String && (((String) value).equals("Moritz") || ((String) value).equals("Maja"))))
			throw new InvalidValueException("False Username");
	}
}