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

	public Notes(List<String> headerList, List<Object> dataList) {
		// Check that the headerList is not null
		if(headerList != null) {
			// Initialize constant strings to represent the class variables' names
			final String doctorIdentification = "DoctorID";
			final String patientIdentification = "PatientID";
			final String notesDate = "Date";
			final String note = "Note";
			
			
			// For every member of the header list
			for(int i = 0; i < headerList.size(); i++) {
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
				// Otherwise print an error about initializing an illegal value
				else {
					System.out.println("Error: initializing an illegal value for notes");
				}
			}
		}
		// If the headerList is null print an error about initializing with no values
		else {
			System.out.println("Error: initializing Notes with no values.");
		}
	}
	
	public String getPatientID() {
		return PatientID;
	}
	
	public void setPatientID(String patientID) {
		this.PatientID = patientID;
	}

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
	
}
