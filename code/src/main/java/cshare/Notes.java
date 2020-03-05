package cshare;

import java.util.Date;

/*
 * -DoctorID
-Date -Appointment Time
 */
public class Notes {
	private String DoctorID;
	private Date AppointmentDate;
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
