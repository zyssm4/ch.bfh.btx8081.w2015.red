package ch.bfh.btx8081.w2015.red.Schlurp.infopage;
/**
 * A <code>Infopage</code> object represents an information page (abstraction) of a patient with its
 * following data (name, first name and phone number).
 * The data is first generated from the input of the patient in textfields and will be written to a text file.
 * In future the content of the infopage will be retrieved from the text file and displayed in the text fields.
 * If the patient makes changes and saves them, the text file will be overwritten with the new content.
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
