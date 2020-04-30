package backend.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.classes.Diagnosis;
import backend.classes.Doctor;


public class DoctorDAO extends GenericDAO{
	//SQLConnectionPool p; 
	public DoctorDAO(){
		super();
	}
	public Doctor getDoctor(String id) {
		Doctor s = null; 
		String [] params = {id};
	    List<List<Object>> data = this.query("*","Doctor, User "," WHERE Doctor.ID = User.ID AND User.ID = ?", params);
		// If we are getting the doctor by id, there should only always be only 0..1 doctors
	    // with this id
	    assert(data.size() < MAX_SINGLET_DATA_SIZE);
	    System.out.println("ID" + id);
	    if(data.size() > MIN_DATA_SIZE) {
	    	s = new Doctor(listToString(data.get(0)), data.get(1));
		}
		return s; 		
				
	}
	public Doctor getDoctor(String email, String password) {
		Doctor s = null; 
		String [] params = {email, password};
	    List<List<Object>> data = this.query("*","Doctor, User "," WHERE Doctor.ID = User.ID AND User.Email = ? AND User.Password = MD5(?)", params);
		// If we are getting the doctor by id, there should only always be only 0..1 doctors
	    // with this id
	    assert(data.size() < MAX_SINGLET_DATA_SIZE);
	    if(data.size() > MIN_DATA_SIZE) {
	    	System.out.println("HERE");
	    	s = new Doctor(listToString(data.get(0)), data.get(1));
		}
		return s; 		
				
	}

	
	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		this.insert("Doctor", fields, params);
		
	}
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("Doctor", fields, params);
	}
	@Override
	public List<Doctor> getData(String[] fields, String[] params) {
	    for (int i = 0; i < fields.length; i++) {
	    	if(fields[i].contentEquals("ID")) {
	    		fields[i] = "Doctor.ID";
	    	}
	    }
	    String rmStr = "Doctor.ID = User.ID"; 
	    
	    String rm = this.generateRmStr(fields, params);
	    if (fields.length > 0) {
	    	rmStr = rm + " AND " + rmStr; 
	    }else {
	    	rmStr = " WHERE " + rmStr; 
	    }
		
		List<List<Object>> stuff = this.query("*", "Doctor, User", rmStr, params);
		List<Doctor> d = new ArrayList<Doctor>(); 
		if (stuff.size() > MIN_DATA_SIZE) {
			//Get the header row. The first row returned should be the header row
			List<Object> header = stuff.get(0);
			List<String> headerRow  = new ArrayList<String> (); 
			
			for (Object h: header) {
				headerRow.add(h.toString());
			}
			for(int i = MIN_DATA_SIZE; i < stuff.size(); i++) {
				d.add(new Doctor(headerRow, stuff.get(i)));
			}
		}
		return d;
	}

	@Override
	public void updateTable(String[] setFields, String[] setParams, String[] fields, String[] params)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
