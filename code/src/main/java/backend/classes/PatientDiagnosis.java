package backend.classes;

import java.util.Date;

public class PatientDiagnosis {
	private String PatientID; 
	private String DoctorID; 
	private String Name; 
	private Date DiagnosisDate; 

	public PatientDiagnosis() {
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
