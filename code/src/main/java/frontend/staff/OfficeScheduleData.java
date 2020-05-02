package frontend.staff;

/**
 * Contains the data to fill the office schedule
 *
 */
public class OfficeScheduleData {
	/**
	 * Defines a class containing office schedule data
	 * 
	 * 
	 * @author katiewokoek
	 *
	 */
	private String time;
	private String appointmentName;
	
	/**
	 * initializes instance of OfficeScheduleData
	 */
	public OfficeScheduleData() {
		time = "";
		appointmentName = "";
	}
	
	/**
	 * initializes instance of OfficeScheduleData
	 * 
	 * @param t the time of the schedule item
	 * @param n the appointment title
	 */
	public OfficeScheduleData(String t, String n) {
		time = t;
		appointmentName = n;
	}
	
	/**
	 * gets the time of the schedule item
	 * 
	 * @return time the time of the schedule item
	 * 
	 */
	public String getTime() {
		return time;
	}
	
	/**
	 * sets the time of the schedule item
	 * 
	 * @param time the time of the office schedule item
	 */
	public void setTime(String time) {
		this.time = time;
	}
	
	/**
	 * get the appointment name
	 * 
	 * @return appointmentName the name of the appointment
	 */
	public String getAppointmentName() {
		return appointmentName;
	}
	
	/**
	 * sets the name of the appointment
	 * 
	 * @param appointmentName the name of the appointment
	 */
	public void setAppointmentName(String appointmentName) {
		this.appointmentName = appointmentName;
	}
}
