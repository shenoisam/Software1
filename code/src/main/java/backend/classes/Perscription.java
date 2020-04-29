package backend.classes;

import java.util.Date;
import java.util.List;

public class Perscription {
	private String PerscriptionName;
	private double Dosage;
	private int NumberRefills;
	private String DoctorID;
	private String PatientID;
	private Date DateVal; 
	
	public Perscription(List<String> headerRow, List<Object> list) {
		//TODO: implement 
		PerscriptionName = "Pres 1";
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
