package backend.classes;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class TestOrder {
	private String DoctorID; 
	private String TestName; 
	private LocalDateTime DateOrdered; 
	private String PatientID; 
	private Test test;
	
	public TestOrder(List<String> headerList, List<Object> list) {
		if(headerList != null) {
    		final String docID = "DoctorID", tst = "Test", date = "DateVal", pID = "PatientID";
    		
    		for(int i = 0; i < headerList.size(); i++) {
    			String headerVal = headerList.get(i);
    			
    			if(headerVal.contentEquals(docID)) {
    				DoctorID = (String)list.get(i);
    			} else if(headerVal.contentEquals(tst)) {
    				test = new Test();
    				test.setName((String)list.get(i));
    				TestName = (String)list.get(i);
    			} else if(headerVal.contentEquals(date)) {
    				DateOrdered = ((java.sql.Timestamp)list.get(i)).toLocalDateTime();
    			} else if(headerVal.contentEquals(pID)) {
    				PatientID = (String)list.get(i);
    			}
    		}
    	} else {
    		System.out.println("Error: initializing from no values");
    	}
	}

	public TestOrder() {
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

	public LocalDateTime getDateOrdered() {
		return DateOrdered;
	}

	public void setDateOrdered(LocalDateTime dateOrdered) {
		DateOrdered = dateOrdered;
	}

	public String getPatientID() {
		return PatientID;
	}

	public void setPatientID(String patientID) {
		PatientID = patientID;
	}
	

}
