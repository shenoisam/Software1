package backend.classes;

import java.util.List;

import frontend.EHRRunner;
import frontend.GenericRunner;
import frontend.provider.ProviderRunner;
import frontend.staff.Runner;

public class Staff extends HealthCareProvider {
    private String StaffID;
    private String title; 
    
    public Staff(List<String> headerList, List<Object> list) {
    	if(headerList != null) {
    		final String id = "ID", ttl = "Title";
    		
    		for(int i = 0; i < headerList.size(); i++) {
    			String headerVal = headerList.get(i);
    			
    			if(headerVal.contentEquals(id)) {
    				StaffID = (String)list.get(i);
    			} else if(headerVal.contentEquals(ttl)) {
    				title = (String)list.get(i);
    			}
    		}
    	} else {
    		System.out.println("Error: initializing from no values");
    	}
    }
    
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
	public GenericRunner accept(EHRRunner r) {
	   return new Runner(r);
	}

}
