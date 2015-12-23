package ch.bfh.btx8081.w2015.red.Schlurp.persistenceLayer;

import java.util.ArrayList;

import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.DailyMedicamentList;
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
	private String user = null;

	private MedicineManager() {
	}

	public static MedicineManager getInstance() {
		if (mc == null) {
			mc = new MedicineManager();
		}
		return mc;
	}

	/*
	 * public void addMedicament(Medicament medi) { MediList.add(medi);
	 * MedicamentList.writeMediToMediplan(MediList, (user + FILENAMEPART +
	 * FILETYPE)); }
	 */

	public void removeMedicament(Medicament medi) {
		//MediList.remove(medi);
		setMediList(MedicamentList.exists(medi, getMediList()));
		MedicamentList.writeMediToMediplan(MediList, (user + FILENAMEPART + FILETYPE));
	}

	public ArrayList<Medicament> getMediList() {
		return MediList;
	}

	public void setMediList(ArrayList<Medicament> mediList) {
		this.MediList = mediList;
	}

	public void saveMedicament(String user, Medicament medi) {
		setMediList(MedicamentList.exists(medi, getMediList()));
		MediList.add(medi);
		MedicamentList.writeMediToMediplan(MediList, (user + FILENAMEPART + FILETYPE));
	}

	public void createMediListObject(String username) {
		MediList = MedicamentList.readInformationsFromMediplan(username + FILENAMEPART + FILETYPE);
	}

	public void createDailyListObject(String username) {
		MediList = DailyMedicamentList.readDailyInformations(username + FILENAMEPART + FILETYPE);
	}
}
