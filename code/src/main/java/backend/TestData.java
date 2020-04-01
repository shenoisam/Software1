package backend;

import cshare.*;

public class TestData {
	public TestData(){
		
	}
	
	public int randomGetter() {
		int z = (int)(Math.random() * 3);
		
		return z; 
		
	}
	
	public Doctor getDoctor() {
		return new Doctor(); 
	}
	
	public Staff getStaff() {
		return new Staff(); 
	}
	
	public Patient getPatient() {
		return new Patient(); 
	}

}
