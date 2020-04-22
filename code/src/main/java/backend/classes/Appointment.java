package backend.classes;

import java.util.Date;
import java.util.List;

import backend.NotImplementedException;

/*
 * -Date -User ID 1 -User ID 2
 */
public class Appointment {
	private Date AppointmentDate;
	private String UserID1;
	private String UserID2;
	
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
					this.AppointmentDate = (Date)list.get(i);
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
					this.UserID1 = (String)list.get(i);
				}
				// Otherwise if it represents the Patient ID
				else if(headerVal.contentEquals(Patient)) {
					// Initialize the patient ID
					this.UserID2 =  (String)list.get(i);
				}
				// If the header is any other string
				else {
					// Print that there is an error since there is an
					// illegal value attempting initialization.
					System.out.println("Error: initializing illegal value.");
				}
				
			}
		}
		// Otherwise if there are no values to read in print an error
		else {
			System.out.println("Error: initializing from no values.");
		}
	}
	public Date getAppointmentDate() {
		return AppointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		AppointmentDate = appointmentDate;
	}
	public String getUserID1() {
		return UserID1;
	}
	public void setUserID1(String userID1) {
		UserID1 = userID1;
	}
	public String getUserID2() {
		return UserID2;
	}
	public void setUserID2(String userID2) {
		UserID2 = userID2;
	}
	
}
