package ch.bfh.btx8081.w2015.red.Schlurp.persistenceLayer;

import java.util.ArrayList;

import ch.bfh.btx8081.w2015.red.Schlurp.infopage.Infopage;
import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.Medicament;

/**
 * The UserManager is used to call certain Methods from the class Infopage and
 * MedicineManager.
 * <p>
 * The Methods are used to link the Application Logic with the Data provided by
 * the text Files and the Data entered by the User.
 * 
 * @author Rea, Mauro
 *
 */
public class UserManager {

	private static UserManager uc = null;
	private Infopage infopage = null;
	private String user = null;
	private final String FILETYPE = ".txt";
	private MedicineManager mc = null;

	/**
	 * Constructor who calls the getInstance() Method of the MedicineManager
	 * class, so we can call the methods of the MedicineManger with the
	 * UserManager
	 */
	private UserManager() {
		mc = MedicineManager.getInstance();
	}

	/**
	 * Instances uc of type UserManager if uc is null. This method is necessary,
	 * to be sure it exists only one instance of the class UserManager
	 * 
	 * @return - an UserManager Object
	 */
	public static UserManager getInstance() {
		if (uc == null) {
			uc = new UserManager();
		}
		return uc;
	}

	/**
	 * reads the Informations form the appropriate text file and overwrites the
	 * Infopage object with it's content
	 * 
	 * @param user
	 *            - the name of the current user
	 */
	public void createInfoPageObject(String user) {
		infopage = Infopage.readInformationsFromFile(user + FILETYPE);
	}

	/**
	 * overwrites the Infopageobject of the Usermanager and writes the content
	 * to a text file
	 * 
	 * @param iP
	 */
	public void saveInfopage(Infopage iP) {
		infopage = iP;
		Infopage.writeInfomationsToFile(infopage, user + FILETYPE);
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

	public void saveMedicament(Medicament medi) {
		mc.saveMedicament(uc.getUser(), medi);
	}

	public void createMediListObject(String username) {
		mc.createMediListObject(username);
	}

	public ArrayList<Medicament> getMediList() {
		return mc.getMediList();
	}

	public void removeMedicament(String mediName) {
		mc.removeMedicament(mediName, uc.getUser());
	}
}
