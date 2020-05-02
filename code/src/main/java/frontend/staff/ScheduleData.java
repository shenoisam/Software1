package frontend.staff;

import java.util.Date;

/**
 * Contains the data for the schedule
 *
 */
public class ScheduleData {
	private String FirstName;
	private String LastName;
	private Date DateOfVisit;
	private boolean BillSent;
	private Date DateBillSent;
	private boolean BillPaid;
	
	/**
	 * initializes a new instance of a ScheduleData object
	 */
	ScheduleData() {
		FirstName = "";
		LastName = "";
		DateOfVisit = null;
		BillSent = false;
		DateBillSent = null;
		BillPaid = false;
	}
	
	/**
	 * initializes a new instance of a ScheduleData object
	 * 
	 * @param firstName the patients first name
	 * @param lastname the patients last name
	 * @param visited the date the patient came in for an appointment
	 * @param sent if the bill has been sent yet
	 * @param billSent the date the bill was sent
	 * @param paid if the bill has been paid yet
	 */
	ScheduleData(String firstName, String lastName, Date visited, boolean sent, Date billSent, boolean paid) {
		FirstName = firstName;
		LastName = lastName;
		DateOfVisit = visited;
		BillSent = sent;
		DateBillSent = billSent;
		BillPaid = paid;
	}

	/**
	 * gets the first name of the patient
	 * 
	 * @return the first name of the patient
	 */
	public String getFirstName() {
		return FirstName;
	}

	/**
	 * sets the first name of the patient
	 * 
	 * @param firstName the first name of the patient
	 */
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	/**
	 * gets the last name of the patient
	 * 
	 * @return the last name of the patient
	 */
	public String getLastName() {
		return LastName;
	}

	/**
	 * sets the last name of the patient
	 * 
	 * @param lastName the last name of the patient
	 */
	public void setLastName(String lastName) {
		LastName = lastName;
	}

	/**
	 * gets the date of the visit
	 * 
	 * @return the first name of the patient
	 */
	public Date getDateOfVisit() {
		return DateOfVisit;
	}

	/**
	 * sets the date of the appointment
	 * 
	 * @param dateOfVisit the date of the appointment
	 */
	public void setDateOfVisit(Date dateOfVisit) {
		DateOfVisit = dateOfVisit;
	}
	
	/**
	 * gets if the bill has been sent
	 * 
	 * @return if the bill has been sent
	 */
	public boolean isBillSent() {
		return BillSent;
	}

	/**
	 * sets if the bill has been sent yet
	 * 
	 * @param billSent if the bill has been sent
	 */
	public void setBillSent(boolean billSent) {
		BillSent = billSent;
	}

	/**
	 * gets the date the bill was sent
	 * 
	 * @return the date the bill was sent
	 */
	public Date getDateBillSent() {
		return DateBillSent;
	}

	/**
	 * sets the date the bill was sent
	 * 
	 * @param dateBillSent the date the bill was sent
	 */
	public void setDateBillSent(Date dateBillSent) {
		DateBillSent = dateBillSent;
	}

	/**
	 * gets if the bill has been paid
	 * 
	 * @return if the bill has been paid yet
	 */
	public boolean isBillPaid() {
		return BillPaid;
	}

	/**
	 * sets if the bill has been paid
	 * 
	 * @param billPaid if the bill has been paid yet
	 */
	public void setBillPaid(boolean billPaid) {
		BillPaid = billPaid;
	}
	
}
