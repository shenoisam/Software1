package backend.classes;

import java.util.List;

import frontend.EHRRunner;
import frontend.GenericRunner;
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
	public Staff(List<String> listToString, List<Object> list) {
		// TODO Auto-generated constructor stub
		super(listToString, list);
	}
	public String getStaffID() {
		return StaffID;
	}
	public void setStaffID(String staffID) {
		StaffID = staffID;
	}
	
	@Override 
	public GenericRunner accept(EHRRunner r) {
	   return new Runner(r);
	}

}
