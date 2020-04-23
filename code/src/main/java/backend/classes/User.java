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


	public User(List<String> headerList, List<Object> dataList) {
		// TODO Auto-generated constructor stub
		for( int i =0; i < headerList.size(); i++) {
			System.out.println("HeaderList[" + i + "]: "+ headerList.get(i) );
			if(headerList.get(i).equals("FirstName")) {
				FirstName = dataList.get(i).toString();
				
			}
			if(headerList.get(i).contentEquals("LastName")) {
				LastName = dataList.get(i).toString();
				
			}
			if(headerList.get(i).contentEquals("Email")) {
				Email = dataList.get(i).toString();
				
			}
			if(headerList.get(i).contentEquals("ID")) {
				ID = dataList.get(i).toString();
			}
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
