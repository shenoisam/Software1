package backend.classes;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import backend.NotImplementedException;
import backend.dao.AppointmentDAO;
import backend.dao.GenericDAO;

/*
 * -Date -User ID 1 -User ID 2
 */
public class Appointment{
	private LocalDateTime AppointmentDate;
	
	//Should we convert this to a composition? Have Doctor and Patient objects in this class that way we can display the correct info
	private String DoctorID;
	private String PatientID;
	
	//Testing adding in composition 
	//private Patient patient; 
	//private Doctor doctor; 

	public Appointment(List<String> headerList, List<Object> list){
		// If there are values to read in
		if(headerList != null) {
			// Create constants to represent the strings
			// which may be present in the header list.
			final String Date = "DateVal", Doctor = "DoctorID", Patient = "PatientID";
			
			// For each value in the header list
			for(int i = 0; i < headerList.size(); i++) {
				// Store the value from the header list in a string
				String headerVal = headerList.get(i);
				
				// If the header represents the Date
				if(headerVal.contentEquals(Date)) {
					// Initialize the object's date
					this.AppointmentDate = ((java.sql.Timestamp)list.get(i)).toLocalDateTime();
				}
				// Otherwise if it represents the Doctor ID
				else if(headerVal.contentEquals(Doctor)) {
					// Initialize the doctor ID
					
					/*
					 * To whomever this may regard,
					 * 	please check that I assigned the doctor
					 *  and patient IDs to the right variable,
					 *  since they are both labeled User idk which
					 *  is which.
					 *  	- John
					 */
					this.DoctorID = (String)list.get(i);
				}
				// Otherwise if it represents the Patient ID
				else if(headerVal.contentEquals(Patient)) {
					// Initialize the patient ID
					this.PatientID =  (String)list.get(i);
				}
				
			}
		}
		
	}

	public LocalDateTime getAppointmentDate() {
		return AppointmentDate;
	}
	public void setAppointmentDate(LocalDateTime appointmentDate) {
		AppointmentDate = appointmentDate;
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
	@Override
	public String toString() {
		return "Appointment [AppointmentDate=" + AppointmentDate + ", DoctorID=" + DoctorID + ", PatientID=" + PatientID
				+ "]";
	}


	
	
}
