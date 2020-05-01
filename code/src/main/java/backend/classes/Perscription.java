package backend.classes;

import java.util.Date;
import java.util.List;

public class Perscription {
	private String PerscriptionName;
	private double Dosage;
	private int NumberRefills;
	private String DoctorID;
	private String PatientID;
	
	/*
	 * Prescription constructor
	 * 
	 * Parameters: receives list of header names and list of objects
	 * 
	 * list of objects contains all data fields for Prescription object
	 * (eg. Dosage, DoctorID, PatientID, etc.)
	 * 
	 * Constructor iterates through the object list, matching each element
	 * with the corresponding header in the headerList, and fills the 
	 * Prescription object with the correct data
	 *  
	 */
	public Perscription(List<String> headerList, List<Object> list) {
		// Test that headerList has values
		if(headerList != null) {
			// Generate strings for fields in MySQL
			final String name = "Name", doctorID = "DoctorID", patientID = "PatientID",
					dosage = "Dosage", numRefills = "NumRefills";
			
			// Find each value in header list
			for(int i = 0; i < headerList.size(); i++) {
				String headerVal = headerList.get(i);
				
				// Fill the appropriate fields
				if(headerVal.contentEquals(name)) {
					PerscriptionName = (String)list.get(i);
				} else if (headerVal.contentEquals(doctorID)) {
					DoctorID = (String)list.get(i);
				} else if (headerVal.contentEquals(patientID)) {
					PatientID = (String)list.get(i);
				} else if (headerVal.contentEquals(dosage)) {
					Dosage = (Float)list.get(i);
				} else if (headerVal.contentEquals(numRefills)) {
					NumberRefills = (Integer)list.get(i);
				} 
			}
		} else {
			System.out.println("Error: initializing from no values");
		}
	}
	
	public String getPerscriptionName() {
		return PerscriptionName;
	}
	public void setPerscriptionName(String perscriptionName) {
		PerscriptionName = perscriptionName;
	}
	public double getDosage() {
		return Dosage;
	}
	public void setDosage(double dosage) {
		Dosage = dosage;
	}
	public int getNumberRefills() {
		return NumberRefills;
	}
	public void setNumberRefills(int numberRefills) {
		NumberRefills = numberRefills;
	}
	public String getDoctorID() {
		return DoctorID;
	}
	public void setDoctorID(String doctorID) {
		DoctorID = doctorID;
	}
	public String getPatientID() {
		return PatientID;
	}
	public void setPatientID(String patientID) {
		PatientID = patientID;
	}

}
