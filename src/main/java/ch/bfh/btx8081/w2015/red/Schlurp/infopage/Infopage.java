package ch.bfh.btx8081.w2015.red.Schlurp.infopage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
import java.util.Scanner;

import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.Medicament;
import ch.bfh.btx8081.w2015.red.Schlurp.person.Doctor;
import ch.bfh.btx8081.w2015.red.Schlurp.person.FamilyMember;
import ch.bfh.btx8081.w2015.red.Schlurp.person.Patient;

/**
 * A <code>Infopage</code> object represents an information page (abstraction)
 * of a patient with its following data (name, first name and phone number). The
 * data is first generated from the input of the patient in textfields and will
 * be written to a text file. In future the content of the infopage will be
 * retrieved from the text file and displayed in the text fields. If the patient
 * makes changes and saves them, the text file will be overwritten with the new
 * content.
 * <p>
 * Note: The input data are not validated.
 * 
 * @author Rea
 * @author Kaspar
 * @version V30.11.2015
 */
public class Infopage {

	private Patient patient = null;

	/**
	 * Constructs a <code>Infopage</code> with one <code>Patient</code>
	 * 
	 * @param patient
	 */
	public Infopage(Patient patient) {
		this.patient = patient;
	}

	/**
	 * Reads the content of a text file with the name inputFileName and stores
	 * the read data in an Infopage object.
	 * 
	 * @return returns an infopage object
	 */
	public static Infopage readInformationsFromFile(String inputFileName) throws FileNotFoundException {

		Scanner input = new Scanner(new File(inputFileName), "UTF-16");
		String delimiter = ";";
		Infopage info = null;

		while (input.hasNextLine()) {
			String data = input.nextLine();
			String[] splittedData = data.split(delimiter);
			for (int i = 0; i < splittedData.length; i++) {
				splittedData[i] = splittedData[i].trim();
			}
			info = new Infopage(new Patient(splittedData[0], splittedData[1], splittedData[2], splittedData[3],
					splittedData[4], splittedData[5], new Medicament(splittedData[6]),
					new Doctor(splittedData[7], splittedData[8]), new FamilyMember(splittedData[9], splittedData[10])));
		}

		input.close();
		return info;
	}

	/**
	 * Writes the data of the infopage to a defined Textfile
	 * 
	 */
	public static void writeInfomationsToFile(Infopage infos, String outputfileName)
			throws FileNotFoundException, UnsupportedEncodingException {

		final PrintWriter out = new PrintWriter(outputfileName, "UTF-16");
		String delimiter = ";";

		out.format(infos.patient.getLastName() + delimiter + " " + infos.patient.getFirstName() + delimiter + " "
				+ infos.patient.getInsurance() + delimiter + " " + infos.patient.getInsPolicyNb() + delimiter + " "
				+ infos.patient.getDisease() + delimiter + " " + infos.patient.getFirstTreatment() + delimiter + " "
				+ infos.patient.getMedicaments() + delimiter + " " + infos.patient.getDoctor().getLastName() + delimiter
				+ " " + infos.patient.getDoctor().getPhoneNb() + delimiter + " "
				+ infos.patient.getFmember().getLastName() + delimiter + " " + infos.patient.getFmember().getPhoneNb()
				+ "%n");

		out.close();
	}

	public Patient getPatient() {
		return patient;
	}

	/**
	 * returns a String representation of Infopage, which is only used for
	 * testing
	 * 
	 * @return String representation of Infopage
	 */
	@Override
	public String toString() {
		return "Infopage [patient=" + patient + "]";
	}
}
