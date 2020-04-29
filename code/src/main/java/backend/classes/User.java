package backend.classes;

import java.util.List;
<<<<<<< HEAD
=======

>>>>>>> b0a2518785746ab0f3d47568c484a04d341f20c6
import frontend.EHRRunner;
import frontend.GenericRunner;

public class User {
	private String FirstName; 
	private String LastName; 
	private String Email; 
	private String ID;
	private String Password;
	
	public User(List<String> headerList, List<Object> list) {
		if(headerList != null) {
    		final String fname = "FirstName", lname = "LastName", email = "Email",
    				id = "ID", pswd = "Password";
    		
    		for(int i = 0; i < headerList.size(); i++) {
    			String headerVal = headerList.get(i);
    			
    			if(headerVal.contentEquals(fname)) {
    				FirstName = (String)list.get(i);
    			} else if(headerVal.contentEquals(lname)) {
    				LastName = (String)list.get(i);
    			} else if(headerVal.contentEquals(email)) {
    				Email = (String)list.get(i);
    			} else if(headerVal.contentEquals(pswd)) {
    				Password = (String)list.get(i);
    			}
    		}
    	} else {
    		System.out.println("Error: initializing from no values");
    	}
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public User(List<String> headerList, List<Object> dataList) {
		// TODO Auto-generated constructor stub
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
		
	}
	

}
