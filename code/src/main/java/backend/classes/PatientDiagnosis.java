package backend.classes;

import java.util.Date;
import java.util.List;

public class PatientDiagnosis {
	private String PatientID; 
	private String DoctorID; 
	private String Name; 
	private Date DiagnosisDate; 


	public PatientDiagnosis(List<String> headerList, List<Object> dataList) {
		// Check that the headerList is not null
		if(headerList != null) {
			// Create string constants to represent the class variables
			final String patientIdentification = "PatientID";
			final String diagnosis = "Diagnosis";
			final String doctorIdentification = "DoctorID";
			final String date = "DateVal";
			
			// For every value in the headerList
			for(int i = 0; i < headerList.size(); i++) {
				
				// If the string represents the patient ID
				if(headerList.get(i).contentEquals(patientIdentification)) {
					// Initialize patient ID from the data list
					this.PatientID = (String)dataList.get(i);
				}
				// Otherwise if it represents the doctor ID
				else if(headerList.get(i).contentEquals(doctorIdentification)) {
					// Initialize the doctor ID from the data list
					this.DoctorID = (String)dataList.get(i);
				}
				// Otherwise if it represents the diagnosis name
				else if(headerList.get(i).contentEquals(diagnosis)) {
					// Get a diagnosis name from the data list
					this.Name = (String)dataList.get(i);
				}
				// Otherwise if it represents the diagnosis date
				else if(headerList.get(i).contentEquals(date)) {
					// Get the diagnosis date from the data list
					this.DiagnosisDate = (Date)dataList.get(i);
				}
				// In any other case report an error for initializing an illegal value
				else {
					System.out.println("Error: initializing illegal Patient value");
				}
			}
		}
		
	}

	public String getPatientID() {
		return PatientID;
	}

	public void setPatientID(String patientID) {
		PatientID = patientID;
	}

	public String getDoctorID() {
		return DoctorID;
	}

	public void setDoctorID(String doctorID) {
		DoctorID = doctorID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}


	public Date getDate() {
		return DiagnosisDate;
	}

	public void setDate(Date date) {
		this.DiagnosisDate = date;
	}
	

}
