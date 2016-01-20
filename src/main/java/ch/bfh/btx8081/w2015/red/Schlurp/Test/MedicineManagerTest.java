package ch.bfh.btx8081.w2015.red.Schlurp.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.Medicament;
import ch.bfh.btx8081.w2015.red.Schlurp.persistenceLayer.MedicineManager;

/**
 * @author zyssm4, Nosep2
 * @version V17.01.2016
 * 
 *          Tests the Save and Remove Function of the MedicineManager
 *
 */
public class MedicineManagerTest {
	Date datestart = new Date();
	Date dateend = new Date();
	String name = "Aspirin";
	String user = "testUser";
	Medicament testMediFull = new Medicament("Aspirin", "1", "6", datestart,
			dateend);
	Medicament testMediEmpty = new Medicament("", "", "", datestart,
			dateend);
	MedicineManager mc = MedicineManager.getInstance();
	ArrayList<Medicament> MediList = new ArrayList<Medicament>();


	/**
	 * Create a new Medicament Aspirin with the Values from the earlier created
	 * Medicament testMediFull.
	 * 
	 * @result The Medicament will be saved in the Medilist of the
	 *         MedicinManager.
	 */
	@Test
	public void testSaveMedicament() {

		mc.saveMedicament("Aspirin", testMediFull);
		System.out.println(mc.getMediList().get(0));
		assertSame(mc.getMediList().get(0), testMediFull);

	}

	/**
	 * Remove the Medicament Aspirin from the MediList.
	 * 
	 * @result The Medicament will be removed in the Medilist of the
	 *         MedicinManager.
	 */
	@Test
	public void testRemoveMedicament() {
		mc.removeMedicament(testMediFull.getName(), user);
		assertTrue(mc.getMediList().isEmpty());

	}

}
