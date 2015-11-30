package ch.bfh.btx8081.w2015.red.Schlurp.Controller;

import java.io.FileNotFoundException;

import ch.bfh.btx8081.w2015.red.Schlurp.infopage.Infopage;
import ch.bfh.btx8081.w2015.red.Schlurp.person.Patient;

public class ObjectController {

	private static ObjectController oc = null;
	private Infopage infopage = null;
	private Patient patient = null;

	private ObjectController() {
	}

	public static ObjectController getInstance() {
		if (oc == null) {
			oc = new ObjectController();
		}
		return oc;
	}

	public Infopage createInfoPageObject(String username) throws FileNotFoundException {
		infopage = Infopage.readInformationsFromFile(username+".txt");
		return infopage;

	}
}
