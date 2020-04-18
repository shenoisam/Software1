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
	
	public Appointment(List<Object> list) throws NotImplementedException {
		// TODO Auto-generated constructor stub
		throw new NotImplementedException("Appointment List Constructor not created!");
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
