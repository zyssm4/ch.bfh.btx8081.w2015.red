package ch.bfh.btx8081.w2015.red.Schlurp.Controller;

import java.io.FileNotFoundException;

import ch.bfh.btx8081.w2015.red.Schlurp.infopage.Infopage;

public class ObjectController {

	private static ObjectController oc = null;
	private Infopage infopage = null;
	private String user = null;
	private final String FILETYPE = ".txt";

	private ObjectController() {
	}

	public static ObjectController getInstance() {
		if (oc == null) {
			oc = new ObjectController();
		}
		return oc;
	}

	public void createInfoPageObject(String username) throws FileNotFoundException {
		infopage = Infopage.readInformationsFromFile(username + FILETYPE);

	}

	public Infopage getInfopage() {
		return infopage;
	}

	public void createUser(String user) {
		this.user = user;

	}

	public String getUser() {
		return user;
	}

}
