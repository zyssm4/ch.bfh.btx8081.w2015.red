package ch.bfh.btx8081.w2015.red.Schlurp.login;

import com.vaadin.data.Validator;
import com.vaadin.ui.Notification;

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
	private String notification = "False username";

	public void validate(Object value) {
		
		if (!(value instanceof String
				&& (((String) value).equals(patientOne) || ((String) value).equals(patientTwo)))) {
			Notification.show(notification);
		} else {
			usernameValid = true;
		}
	}

	public static boolean isUsernameValid() {
		return usernameValid;
	}
}