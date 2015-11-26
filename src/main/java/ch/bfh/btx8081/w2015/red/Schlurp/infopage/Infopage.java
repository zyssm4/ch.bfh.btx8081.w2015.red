package ch.bfh.btx8081.w2015.red.Schlurp.infopage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

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
 * @version V26.11.2015
 */
public class Infopage {

	private String name = null;
	private String firstname = null;
	private String insurance = null;
	private String insuranceNumber = null;
	private String disease = null;
	private String firstTreatment = null;
	private String medicament = null;
	private String doctorContact = null;
	private String relativeContact = null;

	private static ArrayList<Infopage> infopage = new ArrayList<Infopage>();

	public Infopage(String name, String firstname, String insurance, String insuranceNumber, String disease,
			String firstTreatment, String medicament, String doctorContact, String relativeContact) {
		this.name = name;
		this.firstname = firstname;
		this.insurance = insurance;
		this.insuranceNumber = insuranceNumber;
		this.disease = disease;
		this.firstTreatment = firstTreatment;
		this.medicament = medicament;
		this.doctorContact = doctorContact;
		this.relativeContact = relativeContact;
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
			info = new Infopage(splittedData[0], splittedData[1], splittedData[2], splittedData[3],
					splittedData[4], splittedData[5], splittedData[6], splittedData[7], splittedData[8]);
		}

		input.close();
		return info;
	}

	// Writes the data of the infopage to a defined Textfile
	public static void writeInfomationsToFile(Infopage infos, String outputfileName)
			throws FileNotFoundException, UnsupportedEncodingException {

		final PrintWriter out = new PrintWriter(outputfileName, "UTF-8");
		String delimiter = ";";

		out.format(infos.getName() + delimiter + " " + infos.getFirstname() + delimiter + " " + infos.getInsurance()
				+ delimiter + " " + infos.getInsuranceNumber() + delimiter + " " + infos.getDisease() + delimiter + " "
				+ infos.getFirstTreatment() + delimiter + " " + infos.getMedicament() + delimiter + " "
				+ infos.getDoctorContact() + delimiter + " " + infos.getRelativeContact() + "%n");

		out.close();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getInsuranceNumber() {
		return insuranceNumber;
	}

	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getFirstTreatment() {
		return firstTreatment;
	}

	public void setFirstTreatment(String firstTreatment) {
		this.firstTreatment = firstTreatment;
	}

	public String getMedicament() {
		return medicament;
	}

	public void setMedicament(String medicament) {
		this.medicament = medicament;
	}

	public String getDoctorContact() {
		return doctorContact;
	}

	public void setDoctorContact(String doctorContact) {
		this.doctorContact = doctorContact;
	}

	public String getRelativeContact() {
		return relativeContact;
	}

	public void setRelativeContact(String relativeContact) {
		this.relativeContact = relativeContact;
	}

}
