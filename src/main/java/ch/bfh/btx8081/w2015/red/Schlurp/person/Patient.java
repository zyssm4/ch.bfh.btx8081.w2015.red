package ch.bfh.btx8081.w2015.red.Schlurp.person;

/**
 * A <code>patient</code> object represents a patient (abstraction) with its
 * following data (name, first name, insurance, insurance policy number and
 * first treatment).
 * <p>
 * Note: The input data are not validated.
 * 
 * @author Kaspar
 * @version V26.11.2015
 */
public class Patient extends Person {
	private String insurance;
	private String insPolicyNb;
	private String disease;
	private String firstTreatment;
	private Doctor doctor;
	private FamilyMember fmember;

	/**
	 * Constructs a patient
	 * 
	 * @param lastName
	 *            the lastname
	 * @param firstName
	 *            the firstname
	 * @param insurance
	 *            the insurance name
	 * @param insPolicyNb
	 *            the insurance policy number
	 * @param firstTreatment
	 *            the first treatment
	 * @param disease
	 *            the main disease
	 * @param medicament
	 *            a medicament
	 * @param doctor
	 *            the doctor
	 * @param fmember
	 *            a family member
	 */
	public Patient(String lastName, String firstName, String insurance,
			String insPolicyNb, String disease, String firstTreatment,
			Doctor doctor, FamilyMember fmember) {
		super(lastName, firstName);
		this.insurance = insurance;
		this.insPolicyNb = insPolicyNb;
		this.disease = disease;
		this.firstTreatment = firstTreatment;
		this.doctor = doctor;
		this.fmember = fmember;
	}

	/**
	 * returns the name of the insurance of this <code>Patient</codes>
	 * 
	 * @return the insurance
	 */
	public String getInsurance() {
		return insurance;
	}

	/**
	 * sets the name of the insurance if this <code>Patient</codes>
	 * 
	 * @param insurance
	 *            the insurance to set
	 * 
	 */
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	/**
	 * returns the insurance policy number of this <code>Patient</codes>
	 * 
	 * @return the insPolicyNb
	 */
	public String getInsPolicyNb() {
		return insPolicyNb;
	}

	/**
	 * sets the insurance policy number of this <code>Patient</codes>
	 * 
	 * @param insPolicyNb
	 *            the insPolicyNb to set
	 */
	public void setInsPolicyNb(String insPolicyNb) {
		this.insPolicyNb = insPolicyNb;
	}

	/**
	 * returns the date of the first treatment of this <code>Patient</codes>
	 * 
	 * @return the firstTreatment
	 */
	public String getFirstTreatment() {
		return firstTreatment;
	}

	/**
	 * sets the date of the first treatment of this <code>Patient</codes>
	 * 
	 * @param firstTreatment
	 *            the firstTreatment to set
	 */
	public void setFirstTreatment(String firstTreatment) {
		this.firstTreatment = firstTreatment;
	}

	/**
	 * returns the name of the main disease of this <code>Patient</code>
	 * 
	 * @return the main disease
	 */
	public String getDisease() {
		return disease;
	}

	/**
	 * sets the name of the main disease of this <code>Patient</code>
	 * 
	 * @param disease
	 *            the disease to set
	 */
	public void setDisease(String disease) {
		this.disease = disease;
	}

	/**
	 * returns the <code>Doctor</codes> of this <code>Patient</codes>
	 * 
	 * @return the doctor
	 */
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 * sets the <code>Doctor</codes> of this <code>Patient</codes>
	 * 
	 * @param doctor
	 *            the doctor to set
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
	 * returns the family member of this <code>Patient</codes>
	 * 
	 * @return the family member
	 */
	public FamilyMember getFmember() {
		return fmember;
	}

	/**
	 * sets the family member of this <code>Patient</codes>
	 * 
	 * @param fmember
	 *            the family member to set
	 */
	public void setFmember(FamilyMember fmember) {
		this.fmember = fmember;
	}

	/**
	 * Generated hashCode method,because only used for the Junit tests
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((disease == null) ? 0 : disease.hashCode());
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		result = prime * result
				+ ((firstTreatment == null) ? 0 : firstTreatment.hashCode());
		result = prime * result + ((fmember == null) ? 0 : fmember.hashCode());
		result = prime * result
				+ ((insPolicyNb == null) ? 0 : insPolicyNb.hashCode());
		result = prime * result
				+ ((insurance == null) ? 0 : insurance.hashCode());
		return result;
	}

	/**
	 * Generated equals method, because only used for the Junit tests
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (disease == null) {
			if (other.disease != null)
				return false;
		} else if (!disease.equals(other.disease))
			return false;
		if (doctor == null) {
			if (other.doctor != null)
				return false;
		} else if (!doctor.equals(other.doctor))
			return false;
		if (firstTreatment == null) {
			if (other.firstTreatment != null)
				return false;
		} else if (!firstTreatment.equals(other.firstTreatment))
			return false;
		if (fmember == null) {
			if (other.fmember != null)
				return false;
		} else if (!fmember.equals(other.fmember))
			return false;
		if (insPolicyNb == null) {
			if (other.insPolicyNb != null)
				return false;
		} else if (!insPolicyNb.equals(other.insPolicyNb))
			return false;
		if (insurance == null) {
			if (other.insurance != null)
				return false;
		} else if (!insurance.equals(other.insurance))
			return false;
		return true;
	}

}
