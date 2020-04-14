package backend.classes;

import frontend.EHRRunner;
import frontend.provider.ProviderRunner;
import frontend.staff.Runner;

public class Staff extends HealthCareProvider {
    private String StaffID;
    private String title; 
	public Staff() {
		// TODO Auto-generated constructor stub
	}
	public Staff(String id, String title ) {
		// TODO Auto-generated constructor stub
	}
	public String getStaffID() {
		return StaffID;
	}
	public void setStaffID(String staffID) {
		StaffID = staffID;
	}
	
	@Override 
	public void accept(EHRRunner r) {
		r.setR(new Runner(r));
	}

}
