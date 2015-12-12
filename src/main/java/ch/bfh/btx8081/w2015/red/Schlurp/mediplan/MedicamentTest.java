package ch.bfh.btx8081.w2015.red.Schlurp.mediplan;

import java.util.ArrayList;
import java.util.Date;


public class MedicamentTest {
	
		public static void main(String[] args) {
			ArrayList<Medicament> medicaments = new ArrayList<Medicament>();
			medicaments.add(new Medicament("a", 0, 1, 2, 3, 7, new Date(), new Date(), new Date(), new Date()));
			MedicamentList.writeMediToMediplan(medicaments,
					"mediplan.txt");
			System.out.println(MedicamentList.readInformationsFromMediplan("mediplan.txt").toString());

		}
	}
