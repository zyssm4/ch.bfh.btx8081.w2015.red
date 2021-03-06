package ch.bfh.btx8081.w2015.red.Schlurp.infopage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
import java.util.Scanner;

import ch.bfh.btx8081.w2015.red.Schlurp.person.Doctor;
import ch.bfh.btx8081.w2015.red.Schlurp.person.FamilyMember;
import ch.bfh.btx8081.w2015.red.Schlurp.person.Patient;

/**
 * An <code>Infopage</code> object represents an information page (abstraction)
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
	 * @param inputFileName
	 *            the name of the file that will be read
	 * @return returns an Infopage object
	 * 
	 */
	public static Infopage readInformationsFromFile(String inputFileName) {

		Scanner input = null;
		String delimiter = ";";

		try {
			input = new Scanner(new File(inputFileName), "UTF-16");
		} catch (FileNotFoundException e) {
			try {
				PrintWriter out = new PrintWriter(inputFileName, "UTF-16");
				Infopage infos = new Infopage(new Patient("", "", "", "", "",
						"", new Doctor("", ""), new FamilyMember("", "")));

				out.format(infos.patient.getLastName() + delimiter + " "
						+ infos.patient.getFirstName() + delimiter + " "
						+ infos.patient.getInsurance() + delimiter + " "
						+ infos.patient.getInsPolicyNb() + delimiter + " "
						+ infos.patient.getDisease() + delimiter + " "
						+ infos.patient.getFirstTreatment() + delimiter + " "
						+ infos.patient.getDoctor().getLastName() + delimiter
						+ " " + infos.patient.getDoctor().getPhoneNb()
						+ delimiter + " "
						+ infos.patient.getFmember().getLastName() + delimiter
						+ " " + infos.patient.getFmember().getPhoneNb() + "%n");
				out.close();
				input = new Scanner(new File(inputFileName), "UTF-16");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}

		Infopage info = null;

		while (input.hasNextLine()) {
			String data = input.nextLine();
			String[] splittedData = data.split(delimiter);
			for (int i = 0; i < splittedData.length; i++) {
				splittedData[i] = splittedData[i].trim();
			}
			info = new Infopage(new Patient(splittedData[0], splittedData[1],
					splittedData[2], splittedData[3], splittedData[4],
					splittedData[5], new Doctor(splittedData[6],
							splittedData[7]), new FamilyMember(splittedData[8],
							splittedData[9])));
		}

		input.close();
		return info;
	}

	/**
	 * Writes the data of the infopage to a defined Textfile
	 * 
	 * @param infos
	 *            a infopage object
	 * @param outputfileName
	 *            the name of the file which will be (over)written
	 */
	public static void writeInfomationsToFile(Infopage infos,
			String outputfileName) {

		PrintWriter out = null;
		try {
			out = new PrintWriter(outputfileName, "UTF-16");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String delimiter = ";";

		out.format(infos.patient.getLastName() + delimiter + " "
				+ infos.patient.getFirstName() + delimiter + " "
				+ infos.patient.getInsurance() + delimiter + " "
				+ infos.patient.getInsPolicyNb() + delimiter + " "
				+ infos.patient.getDisease() + delimiter + " "
				+ infos.patient.getFirstTreatment() + delimiter + " "
				+ infos.patient.getDoctor().getLastName() + delimiter + " "
				+ infos.patient.getDoctor().getPhoneNb() + delimiter + " "
				+ infos.patient.getFmember().getLastName() + delimiter + " "
				+ infos.patient.getFmember().getPhoneNb() + "%n");

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

	/**
	 * Generated hashCode method,because only used for the Junit tests
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		return result;
	}

	/**
	 * Generated equals method, because only used for the Junit tests
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Infopage other = (Infopage) obj;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		return true;
	}

}
