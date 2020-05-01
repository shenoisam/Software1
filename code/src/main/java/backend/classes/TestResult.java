package backend.classes;
/*
 * -Test Name -Date -PatientID -Result
 */

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 
 * TestResult class that stores data about
 * the results of a test
 * 
 * @author mmorr
 *
 */
public class TestResult {
	private String TestName;
	private Date TestDate;
	private String PatientID;
	private String Result;
	
	/**
	 * TestResult constructor
	 * 
	 * @param: list of header names
	 * @param list of objects that contains all data fields for TestResult object
	 * (eg. TestName, TestDate, etc.)
	 * @return TestResult object
	 * 
	 * Constructor iterates through the object list, matching each element
	 * with the corresponding header in the headerList, and fills the 
	 * TestResult object with the correct data
	 * 
	 * author: matthew morris
	 */
	public TestResult(List<String> headerList, List<Object> list) {
		if(headerList != null) {
    		final String res = "Result", tst = "Test", date = "DateVal", patID = "PatientID";
    		
    		for(int i = 0; i < headerList.size(); i++) {
    			String headerVal = headerList.get(i);
    			
    			if(headerVal.contentEquals(res)) {
    				Result = (String)list.get(i);
    			} else if(headerVal.contentEquals(tst)) {
    				TestName = (String)list.get(i);
    			} else if(headerVal.contentEquals(date)) {
    				TestDate = (java.util.Date)list.get(i);
    			} else if(headerVal.contentEquals(patID)) {
    				PatientID = (String)list.get(i);
    			}
    		}
    	} else {
    		System.out.println("Error: initializing from no values");
    	}
	}
	
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
