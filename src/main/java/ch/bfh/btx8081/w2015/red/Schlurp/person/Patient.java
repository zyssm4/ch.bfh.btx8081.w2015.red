package ch.bfh.btx8081.w2015.red.Schlurp.person;

import java.util.ArrayList;
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
	private Long insPolicyNb;
	private Date firstTreatment;
	private ArrayList<Medicament> medicaments;
	private Doctor doctor;
	private FamilyMember fmember;
	/**
	 * Constructs a patient
	 * 
	 * @param lastName
	 * 			the last name
	 * @param firstName
	 * 			the first name
	 * @param insurance
	 * 			the insurance name
	 * @param insPolicyNb
	 * 			the insurance policy number
	 * @param firstTreatment
	 * 			the date of the first treatment
	 */
	public Patient(String lastName, String firstName, String insurance, Long insPolicyNb, Date firstTreatment) {
		super(lastName, firstName);
		this.insurance = insurance;
		this.insPolicyNb = insPolicyNb;
		this.firstTreatment = firstTreatment;
	}
	/**
	 * Constructs a patient 
	 * 
	 * @param lastName
	 * 			the last name
	 * @param firstName
	 * 			the first name
	 * @param insurance
	 * 			the insurance name
	 * @param insPolicyNb
	 * 			the insurance policy number
	 */
	public Patient(String lastName, String firstName, String insurance, Long insPolicyNb) {
		super(lastName, firstName);
		this.insurance = insurance;
		this.insPolicyNb = insPolicyNb;
	}
	/**
	 * Construct a patient
	 * 
	 * @param lastName
	 * 			the last name
	 * @param firstName
	 * 			the first name
	 * @param insurance
	 * 			the insurance nam
	 * @param insPolicyNb
	 * 			the insurance policy number
	 * @param firstTreatment
	 * 			the date of the first treatment
	 * @param medicament
	 * 			a medicament
	 */
	public Patient(String lastName, String firstName, String insurance, Long insPolicyNb, Date firstTreatment, Medicament medicament){
		super(lastName, firstName);
		this.insurance = insurance;
		this.insPolicyNb = insPolicyNb;
		this.firstTreatment = firstTreatment;
		this.medicaments.add(medicament);
	}
	
	/**
	 * Construct a patient
	 * 
	 * @param lastName
	 * 			the last name
	 * @param firstName
	 * 			the first name
	 * @param insurance
	 * 			the insurance name
	 * @param insPolicyNb
	 * 			the insurance policy number
	 * @param firstTreatment
	 * 			the first treatment
	 * @param medicament
	 * 			a medicament
	 * @param doctor
	 * 			the doctor
	 * @param fmember
	 * 			a family member
	 */
	public Patient(String lastName, String firstName, String insurance, Long insPolicyNb, Date firstTreatment,
			Medicament medicament, Doctor doctor, FamilyMember fmember) {
		super(lastName, firstName);
		this.insurance = insurance;
		this.insPolicyNb = insPolicyNb;
		this.firstTreatment = firstTreatment;
		this.medicaments.add(medicament);
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
	public Long getInsPolicyNb() {
		return insPolicyNb;
	}
	/**
	 * sets the insurance policy number of this <code>Patient</codes>
	 * @param insPolicyNb
	 * 			the insPolicyNb to set
	 */
	public void setInsPolicyNb(Long insPolicyNb) {
		this.insPolicyNb = insPolicyNb;
	}
	/**
	 * returns the date of the first treatment of this <code>Patient</codes>
	 * @return the firstTreatment
	 */
	public Date getFirstTreatment() {
		return firstTreatment;
	}
	/**
	 * sets the date of the first treatment of this <code>Patient</codes>
	 * @param firstTreatment
	 * 			the firstTreatment to set
	 */
	public void setFirstTreatment(Date firstTreatment) {
		this.firstTreatment = firstTreatment;
	}
	/**
	 * returns the list of the <code>medicament</code> of this <code>Patient</codes>
	 * @return the medicaments
	 */
	public ArrayList<Medicament> getMedicaments() {
		return medicaments;
	}
	/**
	 * sets a <code>Medicament</codes> into ArrayList <code>medicaments</code> of this <code>Patient</codes>
	 * @param medicament
	 * 			the medicament to set
	 */
	public void setMedicament(Medicament medicament) {
		this.medicaments.add(medicament);
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
