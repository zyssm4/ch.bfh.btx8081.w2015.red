package ch.bfh.btx8081.w2015.red.Schlurp.infopage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
import java.util.Scanner;

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
 * @version V27.11.2015
 */
public class Infopage {

	private Patient patient = null;

	/**
	 * Constructs a <code>Infopage</code> with one <code>Patient</code>
	 * 
	 * @param patient
	 */
	public Infopage(){
	}
	
	public Infopage(Patient patient) {
		this.patient = patient;
	}

	public Infopage(String string, String string2, String string3, String string4, String string5, String string6,
			String string7, String string8, String string9, String string10, String string11) {
		// TODO Auto-generated constructor stub
	}

	// Reads the content of a text file with the name inputFileName and returns
	// the read
	// data in an Infopage object.
	public static Infopage readInformationsFromFile(String inputFileName) throws FileNotFoundException {

		Scanner input = new Scanner(new File(inputFileName));
		String delimiter = ";";
		Infopage info = null;

		while (input.hasNextLine()) {
			String data = input.nextLine();
			String[] splittedData = data.split(delimiter);
			for (int i = 0; i < splittedData.length; i++) {
				splittedData[i] = splittedData[i].trim();
			}
			info = new Infopage(splittedData[0], splittedData[1], splittedData[2], splittedData[3], splittedData[4],
					splittedData[5], splittedData[6], splittedData[7], splittedData[8], splittedData[9],
					splittedData[10]);
		}

		input.close();
		return info;
	}

	// Writes the data of the infopage to a defined Textfile
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

	@Override
	public String toString() {
		return "Infopage [name=" + patient.getLastName() + ", firstname=" + patient.getFirstName() + ", insurance="
				+ patient.getInsurance() + ", insuranceNumber=" + patient.getInsPolicyNb() + ", disease="
				+ patient.getDisease() + ", firstTreatment=" + patient.getFirstTreatment() + ", medicament="
				+ patient.getMedicaments().toString() + ", doctorContactName=" + patient.getDoctor().getLastName()
				+ ", doctorContactPhone=" + patient.getDoctor().getPhoneNb() + ", relativeContactName="
				+ patient.getFmember().getLastName() + ", relativeContactPhone=" + patient.getFmember().getPhoneNb()
				+ "]";
	}
}
