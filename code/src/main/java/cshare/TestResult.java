package cshare;
/*
 * -Test Name -Date -PatientID -Result
 */

import java.util.Date;

public class TestResult {
	private String TestName;
	private Date TestDate;
	private String PatientID;
	private String Result;
	
	public String getTestName() {
		return TestName;
	}
	public void setTestName(String testName) {
		TestName = testName;
	}
	public Date getTestDate() {
		return TestDate;
	}
	public void setTestDate(Date testDate) {
		TestDate = testDate;
	}
	public String getPatientID() {
		return PatientID;
	}
	public void setPatientID(String patientID) {
		PatientID = patientID;
	}
	public String getResult() {
		return Result;
	}
	public void setResult(String result) {
		Result = result;
	}
}
