package ch.bfh.btx8081.w2015.red.Schlurp.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.bfh.btx8081.w2015.red.Schlurp.infopage.Infopage;
import ch.bfh.btx8081.w2015.red.Schlurp.persistenceLayer.UserManager;
import ch.bfh.btx8081.w2015.red.Schlurp.person.Doctor;
import ch.bfh.btx8081.w2015.red.Schlurp.person.FamilyMember;
import ch.bfh.btx8081.w2015.red.Schlurp.person.Patient;

/**
 * 
 * Tests certain methods of the UserManager, amongst other things, the write and
 * read functions of the Infopage.
 *
 * @author nosep1, iselr1
 * @version V17.01.2016
 */
public class TestInfopage {

	Infopage fullInfopage = new Infopage(new Patient("Muster", "Max", "Versicherung", "Nr", "12.12.2015", "Krankheit",
			new Doctor("Arzt", "TelNr"), new FamilyMember("Familie", "TelNr")));
	Infopage emptyInfopage = new Infopage(
			new Patient("", "", "", "", "", "", new Doctor("", ""), new FamilyMember("", "")));
	String user = "Max";
	UserManager um = UserManager.getInstance();

	/**
	 * The method createInfopageObject wants to read from an File with the
	 * username.txt, if it doesn't exsist it creates one with empty Strings for
	 * every Infopagefield
	 */
	@Test
	public void testCreateInfoPageObject() {
		um.createInfoPageObject(user);
		assertEquals(um.getInfopage(), emptyInfopage);
	}

	/**
	 * First we save the FullInfopage to a file and then we read it and
	 * overwrite the Infopageobject of the usermanager, if both methods work
	 * right the test returns true
	 */
	@Test
	public void testSaveInfoPage() {
		um.createUser(user);
		um.saveInfopage(fullInfopage);
		um.createInfoPageObject(user);
		assertEquals(um.getInfopage(), fullInfopage);
	}

	/**
	 * @Test public void test() {
	 * 
	 *       //no Patient yet "".compareTo(Infopage.toString());
	 * 
	 * 
	 * 
	 *       }
	 **/

}
