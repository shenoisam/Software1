package backend.classes;

import java.util.Date;
import java.util.List;

/*
 * -DoctorID
-Date -Appointment Time
 */
public class Notes {
	private String DoctorID;
	private String PatientID;
	private Date AppointmentDate;
	private String Note; 
	private String ChiefComplaint; 
	private String PhysicalExam; 
	private float BodyTemp; 
	private int Pulse; 
	private int Respiration; 
	private String BloodPressure; 

	public Notes(List<String> headerList, List<Object> dataList) {
		// Check that the headerList is not null
		if(headerList != null) {
			// Initialize constant strings to represent the class variables' names
			final String doctorIdentification = "DoctorID";
			final String patientIdentification = "PatientID";
			final String notesDate = "Date";
			final String note = "Note";
			final String complaint = "ChiefComplaint";
			final String ex = "PhysicalExam";
			final String bt = "BodyTemp";
			final String pulse ="Pulse";
			final String res = "Respiration";
			final String bp = "BloodPressure";
			
			
			// For every member of the header list
			for(int i = 0; i < headerList.size(); i++) {
				if(dataList.get(i) != null) {
					// If the doctor ID is at the current index
					if(headerList.get(i).contentEquals(doctorIdentification)) {
						// Initialize the doctor ID value from the data list
						this.DoctorID = (String)dataList.get(i);
					}
					// Otherwise if the patient ID is at the current index
					else if(headerList.get(i).contentEquals(patientIdentification)) {
						// Initialize the patient ID value from the data list
						this.PatientID = (String)dataList.get(i);
					}
					// Otherwise if the date of the notes is at the current index
					else if(headerList.get(i).contentEquals(notesDate)) {
						this.AppointmentDate = (Date)dataList.get(i);
					}
					// Otherwise if the date of the notes is at the current index
					else if(headerList.get(i).contentEquals(note)) {
						this.Note = (String)dataList.get(i);
					}
					// Otherwise if the date of the notes is at the current index
					else if(headerList.get(i).contentEquals(complaint)) {
						this.ChiefComplaint= (String)dataList.get(i);
					}
					// Otherwise if the date of the notes is at the current index
					else if(headerList.get(i).contentEquals(ex)) {
						this.PhysicalExam = (String)dataList.get(i);
					}
					else if(headerList.get(i).contentEquals(bt)) {
						this.BodyTemp = (float)dataList.get(i);
					}
					else if(headerList.get(i).contentEquals(pulse)) {
						this.Pulse = (int)dataList.get(i);
					}
					else if(headerList.get(i).contentEquals(res)) {
						this.Respiration = (int)dataList.get(i);
					}
					else if(headerList.get(i).contentEquals(bp)) {
						this.BloodPressure = (String)dataList.get(i);
					}
					
				}
				// If the headerList is null print an error about initializing with no values
				else {
					System.out.println("Error: initializing Notes with no values.");
				}
			}
		}
	}
	
	public String getPatientID() {
		return PatientID;
	}
	
	public void setPatientID(String patientID) {
		this.PatientID = patientID;
	}
	
	/* This is the sql constructor for the Notes object
	 * 
	 * @param list this list contains the header row 
	 * @param list2 this list contains the value row
	 */
//	public Notes(List<Object> list, List<Object> list2) {
//		// TODO Auto-generated constructor stub
//	}

	public String getDoctorID() {
		return DoctorID;
	}
	public void setDoctorID(String doctorID) {
		DoctorID = doctorID;
	}
	public Date getAppointmentDate() {
		return AppointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		AppointmentDate = appointmentDate;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public String getChiefComplaint() {
		return ChiefComplaint;
	}

	public void setChiefComplaint(String chiefComplaint) {
		ChiefComplaint = chiefComplaint;
	}

	public String getPhysicalExam() {
		return PhysicalExam;
	}

	public void setPhysicalExam(String physicalExam) {
		PhysicalExam = physicalExam;
	}

	public float getBodyTemp() {
		return BodyTemp;
	}

	public void setBodyTemp(float bodyTemp) {
		BodyTemp = bodyTemp;
	}

	public int getPulse() {
		return Pulse;
	}

	public void setPulse(int pulse) {
		Pulse = pulse;
	}

	public int getRespiration() {
		return Respiration;
	}

	public void setRespiration(int respiration) {
		Respiration = respiration;
	}

	public String getBloodPressure() {
		return BloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		BloodPressure = bloodPressure;
	}
	
}
