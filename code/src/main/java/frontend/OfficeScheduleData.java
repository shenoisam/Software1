package frontend;

public class OfficeScheduleData {
	private String time;
	private String appointmentName;
	
	public OfficeScheduleData() {
		time = "";
		appointmentName = "";
	}
	
	public OfficeScheduleData(String t, String n) {
		time = t;
		appointmentName = n;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAppointmentName() {
		return appointmentName;
	}
	public void setAppointmentName(String appointmentName) {
		this.appointmentName = appointmentName;
	}
}
