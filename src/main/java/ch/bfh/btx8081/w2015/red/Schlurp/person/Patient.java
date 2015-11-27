package ch.bfh.btx8081.w2015.red.Schlurp.person;

import java.text.SimpleDateFormat;
import java.util.Date;


import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.Medicament;

/**
 * A <code>patient</code> object represents a patient (abstraction) with its
 * following data (name, first name, insurance, insurance policy number and first treatment).
 * <p>
 * Note: The input data are not validated.
 * 
 * @author Kaspar
 * @version V26.11.2015
 */
public class Patient extends Person {
	private String insurance;
	private String insPolicyNb;
	private String firstTreatment;
	private String disease;
	private Medicament medicament;
//	private ArrayList<Medicament> medicaments;
	private Doctor doctor;
	private FamilyMember fmember;
	/**
	 * Constructs a patient
	 * 
	 * @param lastName
	 * 			the lastname
	 * @param firstName
	 * 			the firstname
	 * @param insurance
	 * 			the insurance name
	 * @param insPolicyNb
	 * 			the insurance policy number
	 * @param firstTreatment
	 * 			the first treatment
	 * @param disease
	 * 			the main disease
	 * @param medicament
	 * 			a medicament
	 * @param doctor
	 * 			the doctor
	 * @param fmember
	 * 			a family member
	 */
	public Patient(String lastName, String firstName, String insurance, String insPolicyNb, Date firstTreatment, String disease,
			Medicament medicament, Doctor doctor, FamilyMember fmember) {
		super(lastName, firstName);
		this.insurance = insurance;
		this.insPolicyNb = insPolicyNb;
		this.firstTreatment = new SimpleDateFormat("dd.MM.yyyy").format(firstTreatment);
		this.disease = disease;
		this.medicament = medicament;
		this.doctor = doctor;
		this.fmember = fmember;
	}
	/**
	 * returns the name of the insurance of this <code>Patient</codes>
	 * @return the insurance
	 */
	public String getInsurance() {
		return insurance;
	}
	/**
	 * sets the name of the insurance if this <code>Patient</codes>
	 * @param insurance
	 * 			the insurance to set
	 * 
	 */
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	/**
	 * returns the insurance policy number of this <code>Patient</codes>
	 * @return the insPolicyNb
	 */
	public String getInsPolicyNb() {
		return insPolicyNb;
	}
	/**
	 * sets the insurance policy number of this <code>Patient</codes>
	 * @param insPolicyNb
	 * 			the insPolicyNb to set
	 */
	public void setInsPolicyNb(String insPolicyNb) {
		this.insPolicyNb = insPolicyNb;
	}
	/**
	 * returns the date of the first treatment of this <code>Patient</codes>
	 * @return the firstTreatment
	 */
	public String getFirstTreatment() {
		return firstTreatment;
	}
	/**
	 * sets the date of the first treatment of this <code>Patient</codes>
	 * @param firstTreatment
	 * 			the firstTreatment to set
	 */
	public void setFirstTreatment(String firstTreatment) {
		this.firstTreatment = firstTreatment;
	}
	/**
	 * returns the name of the main disease of this <code>Patient</code>
	 * @return the main disease
	 */
	public String getDisease(){
		return disease;
	}
	/**
	 * sets the name of the main disease of this <code>Patient</code>
	 * @param disease
	 * 			the disease to set
	 */
	public void setDisease(String disease){
		this.disease = disease;
	}
	/**
	 * returns the list of the <code>medicament</code> of this <code>Patient</codes>
	 * @return the medicaments
	 */
	public String getMedicaments(){
		return medicament.getName();
	}
	/**
	 * sets a <code>Medicament</codes> into ArrayList <code>medicaments</code> of this <code>Patient</codes>
	 * @param medicament
	 * 			the medicament to set
	 */
	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}
	/**
	 * returns the <code>Doctor</codes> of this <code>Patient</codes>
	 * @return the doctor
	 */
	public Doctor getDoctor() {
		return doctor;
	}
	/**
	 * sets the <code>Doctor</codes> of this <code>Patient</codes>
	 * @param doctor
	 * 			the doctor to set
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	/**
	 * returns the family member of this <code>Patient</codes>
	 * @return the family member
	 */
	public FamilyMember getFmember() {
		return fmember;
	}
	/**
	 * sets the family member of this <code>Patient</codes>
	 * @param fmember
	 * 			the family member to set
	 */
	public void setFmember(FamilyMember fmember) {
		this.fmember = fmember;
	}
	
}
