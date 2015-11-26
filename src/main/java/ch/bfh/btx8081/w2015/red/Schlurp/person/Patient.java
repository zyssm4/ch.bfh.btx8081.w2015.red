package ch.bfh.btx8081.w2015.red.Schlurp.person;

import java.util.Date;

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
	/**
	 * Constructs a complete Patient
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
	 * Constructs a Patient with its name, first name, insurance and incurance policy number, without the date of the first treatment
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
	 * returns the name of the insurance of this <code>patient</codes>
	 * @return the insurance
	 */
	public String getInsurance() {
		return insurance;
	}
	/**
	 * sets the name of the insurance if this <code>patient</codes>
	 * @param insurance
	 * 			the insurance to set
	 * 
	 */
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	/**
	 * returns the insurance policy number of this <code>patient</codes>
	 * @return the insPolicyNb
	 */
	public Long getInsPolicyNb() {
		return insPolicyNb;
	}
	/**
	 * sets the insurance policy number of this <code>patient</codes>
	 * @param insPolicyNb
	 * 			the insPolicyNb to set
	 */
	public void setInsPolicyNb(Long insPolicyNb) {
		this.insPolicyNb = insPolicyNb;
	}
	/**
	 * returns the date of the first treatment of this <code>patient</codes>
	 * @return the firstTreatment
	 */
	public Date getFirstTreatment() {
		return firstTreatment;
	}
	/**
	 * sets the date of the first treatment of this <code>patient</codes>
	 * @param firstTreatment
	 * 			the firstTreatment to set
	 */
	public void setFirstTreatment(Date firstTreatment) {
		this.firstTreatment = firstTreatment;
	}
}
