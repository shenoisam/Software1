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
	
	public Appointment(List<String> columnNames, List<Object> list) {
		if(columnNames != null) {
			for(int i = 0; i < columnNames.size(); i++) {
				
			}
		} else {
			System.out.println("Error: No Column Names included");
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
