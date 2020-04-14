package backend.classes;

import java.util.Date;

import frontend.EHRRunner;
import frontend.patient.PatientRunner;
import frontend.provider.ProviderRunner;

public class Patient extends User {
	private Date DOB;
	private char gender; 
	private String PatientID; 
	private String race; 
	private String ethnicity; 
	private boolean married;

	public Patient(String id) {
		PatientID = id;
	}
	public Patient(String id, java.sql.Date date, char gen,String r, String eth, boolean m) {
		// TODO Auto-generated constructor stub
		PatientID = id;
		DOB = date; 
		gender = gen; 
		race = r; 
		ethnicity = eth; 
		married =m; 
		
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getPatientID() {
		return PatientID;
	}

	public void setPatientID(String patientID) {
		PatientID = patientID;
	}
	@Override 
	public void accept(EHRRunner r) {
		r.setR(new PatientRunner(r));
	}
	

}
