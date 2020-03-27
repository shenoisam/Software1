package cshare;

import java.util.Date;

public class TestOrder {
	private String DoctorID; 
	private String TestName; 
	private Date DateOrdered; 
	private String PatientID; 

	public TestOrder() {
		// TODO Auto-generated constructor stub
	}

	public String getDoctorID() {
		return DoctorID;
	}

	public void setDoctorID(String doctorID) {
		DoctorID = doctorID;
	}

	public String getTestName() {
		return TestName;
	}

	public void setTestName(String testName) {
		TestName = testName;
	}

	public Date getDateOrdered() {
		return DateOrdered;
	}

	public void setDateOrdered(Date dateOrdered) {
		DateOrdered = dateOrdered;
	}

	public String getPatientID() {
		return PatientID;
	}

	public void setPatientID(String patientID) {
		PatientID = patientID;
	}
	

}
