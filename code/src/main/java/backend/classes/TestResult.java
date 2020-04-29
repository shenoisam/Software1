package backend.classes;
/*
 * -Test Name -Date -PatientID -Result
 */

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class TestResult {
	private String TestName;
	private LocalDateTime TestDate;
	private String PatientID;
	private String Result;
	
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
    				TestDate = ((java.sql.Timestamp)list.get(i)).toLocalDateTime();
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
	public LocalDateTime getTestDate() {
		return TestDate;
	}
	public void setTestDate(LocalDateTime testDate) {
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
