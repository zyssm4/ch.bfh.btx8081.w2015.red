package ch.bfh.btx8081.w2015.red.Schlurp.login;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import com.vaadin.ui.Notification;

/**
 * Checks if the login credentials(username, password) are correct, based on the
 * file login.txt
 * 
 * @author Rea
 * @version V08.12.2015
 */
public class LoginValidator {

	private String notification = "False user or password";
	private String username;
	private String password;

	/**
	 * Constructor witch has to be constructed with the username and password.
	 * 
	 * @param username
	 *            the String that the user entered as username
	 * @param password
	 *            the String that the user entered as password
	 */
	public LoginValidator(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * Invokes the method searchLoginCredentials. If that method returns false,
	 * it shows a notification that username/password is not correct. If it
	 * returns true, validate returns true too.
	 * 
	 * @return a boolean
	 */
	public boolean validate() {
		if (!(searchLoginCredentials(username, password))) {
			Notification.show(notification);
			return false;
		} else {
			return true;
		}
	}

	/**
	 * SearchLoginCredentials returns true, if the username is found at the
	 * first position of a line and the password at the second position of the
	 * same line.
	 * 
	 * @param username
	 *            the String that the user entered as username
	 * @param password
	 *            the String that the user entered as password
	 * @return a boolean
	 */
	public static Boolean searchLoginCredentials(String username, String password) {
		username = username.trim();
		password = password.trim();

		BufferedReader br = null;
		Boolean valid = false;

		try {
			br = new BufferedReader(new InputStreamReader(
					new FileInputStream("src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/LoginFile/login.txt")));
			String line;
			while (((line = br.readLine()) != null)) {
				String[] login = line.split(";");
				if (login[0].equals(username) && login[1].equals(password)) {
					valid = true;
					break;
				} else {
					valid = false;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (Exception e) {
				System.err.println("Exception while closing bufferedreader " + e.toString());
			}
		}
		return valid;
	}

}