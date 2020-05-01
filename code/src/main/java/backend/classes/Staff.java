package backend.classes;

import java.util.List;

import frontend.EHRRunner;
import frontend.GenericRunner;
import frontend.provider.ProviderRunner;
import frontend.staff.StaffRunner;

/**
 * 
 * Staff class that contains information about a Staff user
 * 
 * @author mmorr
 *
 */
public class Staff extends HealthCareProvider {
    private String StaffID;
    private String title; 
    
    /**
	 * Staff constructor
	 * 
<<<<<<< HEAD
	 * @param list of header names
	 * @param list of objects that contains all data fields for Staff object
	 * (eg. StaffID, title)
	 * 
	 * Constructor iterates through the object list, matching each element
	 * with the corresponding header in the headerList, and fills the 
	 * Staff object with the correct data
	 * 
	 * author: matthew morris
	 */
    public Staff(List<String> headerList, List<Object> list) {
    	super(headerList, list);
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
	
	public String getStaffTitle() {
		return this.title;
	}
	
	public String getStaffID() {
		return StaffID;
	}
	public void setStaffID(String staffID) {
		StaffID = staffID;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override 
	public GenericRunner accept(EHRRunner r) {
	   return new StaffRunner(r);
	}

}
