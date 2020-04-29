package backend.classes;

import java.util.Date;
import java.util.List;

public class TestOrder {
	private String DoctorID; 
	private String TestName; 
	private Date DateOrdered; 
	private String PatientID; 
	private Test test;

	public TestOrder() {
		// TODO Auto-generated constructor stub
	}

	public TestOrder(List<String> headerRow, List<Object> list) {
		// TODO Auto-generated constructor stub
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
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
