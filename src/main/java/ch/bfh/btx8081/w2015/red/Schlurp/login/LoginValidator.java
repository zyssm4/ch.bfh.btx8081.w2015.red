package ch.bfh.btx8081.w2015.red.Schlurp.login;

	import java.io.BufferedReader;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.io.InputStreamReader;

	import com.vaadin.data.Validator;
	import com.vaadin.ui.Notification;

	/**
	 * Validates the password input of the user, if it's valid the boolean
	 * isPasswordValid() turns true.
	 * 
	 * @author Rea
	 * @version V30.11.2015
	 */
public class LoginValidator {

	private String notification = "False user or password";
	private String username;
	private String password;

	public LoginValidator(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public boolean validate() {
		if(!(searchUser(username, password))){
			Notification.show(notification);
			return false;
		} else {
		return true;
		}
	}
	
	public static Boolean searchUser(String username, String password){
		username = username.trim();
		password = password.trim();
		
		BufferedReader br = null;
		Boolean valid = false;
		
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/LoginFile/login.txt")));
			String line;
			while (((line = br.readLine()) != null)) {
				String[] login = line.split(";");
				if (login[0].equals(username) && login[1].equals(password)) {
					valid = true;
					break;
				}
				else{
					valid = false;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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