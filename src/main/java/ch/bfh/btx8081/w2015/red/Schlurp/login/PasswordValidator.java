package ch.bfh.btx8081.w2015.red.Schlurp.login;

import com.vaadin.data.Validator;
import com.vaadin.ui.Notification;


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
	private String notification = "False password";
	
	public void validate(Object value){
		if (!(value instanceof String && ((String) value).equals(password))) {
			Notification.show(notification);
		} else {
			passwordValid = true;
		}

	}

	public static boolean isPasswordValid() {
		return passwordValid;
	}

}
