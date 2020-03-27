package frontend;

import java.util.Date;

public class ScheduleData {
	private String FirstName;
	private String LastName;
	private Date DateOfVisit;
	private boolean BillSent;
	private Date DateBillSent;
	private boolean BillPaid;
	
	ScheduleData() {
		FirstName = "";
		LastName = "";
		DateOfVisit = new Date(2020, 03, 07);
		BillSent = false;
		DateBillSent = new Date(2020, 03, 07);
		BillPaid = false;
	}
	
	ScheduleData(String firstName, String lastName, Date visited, boolean sent, Date billSent, boolean paid) {
		FirstName = firstName;
		LastName = lastName;
		DateOfVisit = visited;
		BillSent = sent;
		DateBillSent = billSent;
		BillPaid = paid;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public Date getDateOfVisit() {
		return DateOfVisit;
	}

	public void setDateOfVisit(Date dateOfVisit) {
		DateOfVisit = dateOfVisit;
	}

	public boolean isBillSent() {
		return BillSent;
	}

	public void setBillSent(boolean billSent) {
		BillSent = billSent;
	}

	public Date getDateBillSent() {
		return DateBillSent;
	}

	public void setDateBillSent(Date dateBillSent) {
		DateBillSent = dateBillSent;
	}

	public boolean isBillPaid() {
		return BillPaid;
	}

	public void setBillPaid(boolean billPaid) {
		BillPaid = billPaid;
	}
	
}
