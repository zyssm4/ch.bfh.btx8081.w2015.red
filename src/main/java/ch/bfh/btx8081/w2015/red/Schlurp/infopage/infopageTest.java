package ch.bfh.btx8081.w2015.red.Schlurp.infopage;

import java.io.IOException;

import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.Medicament;
import ch.bfh.btx8081.w2015.red.Schlurp.person.Doctor;
import ch.bfh.btx8081.w2015.red.Schlurp.person.FamilyMember;
import ch.bfh.btx8081.w2015.red.Schlurp.person.Patient;

public class infopageTest {
	public static void main(String[] args) throws IOException {
		
		Infopage.writeInfomationsToFile(new Infopage(new Patient("a", "b", "c", "d", "e", "f", new Medicament("g"), new Doctor("h", "i"),  new FamilyMember("j", "k"))), "abc.txt");
		
		System.out.println(Infopage.readInformationsFromFile("abc.txt"));
		}
}
