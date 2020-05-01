package backend.classes;

import java.util.List;
import frontend.EHRRunner;
import frontend.GenericRunner;

public class User {

	protected String FirstName; 
	protected String LastName; 
	protected String Email; 
	protected String ID; 
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * User constructor
	 * 
	 * Receives a List of strings (the list of column headers)
	 * and a List of Objects (the data in the table)
	 * 
	 * Generates a User object containing data from the Object list
	 * 
	 * author: matthew morris
	 */
	public User(List<String> headerList, List<Object> list) {
		if(headerList != null) {
    		final String fname = "FirstName", lname = "LastName", email = "Email", id = "ID";
    		
    		for(int i = 0; i < headerList.size(); i++) {
    			String headerVal = headerList.get(i);
    			
    			if(headerVal.contentEquals(fname)) {
    				FirstName = (String)list.get(i);
    			} else if(headerVal.contentEquals(lname)) {
    				LastName = (String)list.get(i);
    			} else if(headerVal.contentEquals(email)) {
    				Email = (String)list.get(i);
    			} else if(headerVal.contentEquals(id)) {
    				ID = (String)list.get(i);
    			}
    		}
    	} else {
    		System.out.println("Error: initializing from no values");
    	}
	}


	@Override
	public String toString() {
		return "User [FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + "]";
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


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public GenericRunner accept(EHRRunner ehrRunner) {
		return null; 

	}
	public String getFullName() {
		return getFirstName()  + " " + getLastName(); 
	}
	
	public void setUserInfo(User u) {
		if (u != null) {
			this.FirstName = u.getFirstName(); 
			this.LastName = u.getLastName();
			this.Email = u.getEmail();
		}
	}
	public String getID() {
		return ID; 
	}

}
