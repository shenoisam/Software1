package cshare;

import java.util.Date;

public class Patient extends User {
	private Date DOB;
	private char gender; 
	private String PatientID; 

	public Patient() {
		// TODO Auto-generated constructor stub
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
	

}
