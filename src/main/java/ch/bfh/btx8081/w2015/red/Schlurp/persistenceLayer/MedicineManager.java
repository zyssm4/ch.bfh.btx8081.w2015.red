package ch.bfh.btx8081.w2015.red.Schlurp.persistenceLayer;

import java.util.ArrayList;

import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.Medicament;
import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.MedicamentList;

/**
 * The Medicine Manager is used to call certain Methods from the class
 * MedicamentList. The Methods of the MedicineManager itself are called by the
 * UserManager witch is used to link the Application Logic with the Data
 * provided by the text Files and the Data entered by the User.
 * 
 * @author Rea, Mauro
 *
 */
public class MedicineManager {

	private ArrayList<Medicament> MediList = new ArrayList<Medicament>();
	private static MedicineManager mc = null;
	private final String FILETYPE = ".txt";
	private final String FILENAMEPART = "mediplan";

	private MedicineManager() {
	}

	public static MedicineManager getInstance() {
		if (mc == null) {
			mc = new MedicineManager();
		}
		return mc;
	}

	// Removes first the Medicament with mediName from the MedicamentList and
	// writes then the new List to the File
	public void removeMedicament(String mediName, String user) {
		setMediList(MedicamentList.removeMedicament(mediName, getMediList()));
		MedicamentList.writeMediToMediplan(MediList,
				(user + FILENAMEPART + FILETYPE));
	}

	public ArrayList<Medicament> getMediList() {
		return MediList;
	}

	public void setMediList(ArrayList<Medicament> mediList) {
		this.MediList = mediList;
	}

	// the medicament to be safed gets first "overwritten" (if it already
	// existed) then the old text file with the old medicamentlist gets
	// overwritten with the new one
	public void saveMedicament(String user, Medicament medi) {
		// Checks first if a Medicament with the same Name already exists in
		// the MedicamentList. If it does, it' gets removed from the List.
		setMediList(MedicamentList.exists(medi, getMediList()));
		MediList.add(medi);
		// Lastly we overwrite the text file with the old medicamentlist with
		// the new one
		MedicamentList.writeMediToMediplan(MediList,
				(user + FILENAMEPART + FILETYPE));
	}

	// reads the Informations form the appropriate text file and generates a new
	// ArrayList of Medicaments for the MediListView
	public void createMediListObject(String username) {
		MediList = MedicamentList.readInformationsFromMediplan(username
				+ FILENAMEPART + FILETYPE);
	}

}
