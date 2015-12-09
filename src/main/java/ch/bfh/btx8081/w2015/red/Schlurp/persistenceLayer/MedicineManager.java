package ch.bfh.btx8081.w2015.red.Schlurp.persistenceLayer;

import java.util.ArrayList;

import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.Medicament;

public class MedicineManager {

	ArrayList<Medicament> MediList = new ArrayList<Medicament>();
	private static MedicineManager mc = null;
	
	private MedicineManager(){
		
	}

	public static MedicineManager getInstance() {
		if (mc == null) {
			mc = new MedicineManager();
		}
		return mc;
	}
	
	public void addMedicament(){
		
	}
	
	public void removeMedicament(Medicament medi){
		
	}
	
	public ArrayList<Medicament> getMedilist(){
		
		return MediList;
	
	}
	public void saveMedicament(){
		
	}
	
}
