package backend.classes;

import java.util.Date;
import java.util.List;

/*
 * -DoctorID
-Date -Appointment Time
 */
public class Notes {
	private String DoctorID;
	private Date AppointmentDate;
	
	
	/* This is the sql constructor for the Notes object
	 * 
	 * @param list this list contains the header row 
	 * @param list2 this list contains the value row
	 */
	public Notes(List<Object> list, List<Object> list2) {
		// TODO Auto-generated constructor stub
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
}
