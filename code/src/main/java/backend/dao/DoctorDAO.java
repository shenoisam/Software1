package backend.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.classes.Diagnosis;
import backend.classes.Doctor;

/**
 * The doctorDAO defines a database access object that connects to the doctor table
 * 
 * 
 * @author samshenoi
 *
 */
public class DoctorDAO extends GenericDAO{
	//SQLConnectionPool p; 
	public DoctorDAO(){
		super();
	}
	
	
	/**
	 * gets a doctor from the database based on id
	 * 
	 * 
	 * @param id the id of the doctor
	 * @return the doctor associated with this id
	 */
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
	
	/**
	 * gets a doctor from the database based on their email and password
	 * 
	 * 
	 * @param email the email of the doctor
	 * @param password the password of the doctor
	 * @return the logged in doctor
	 */
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

	
	/**
	 * inserts into the doctor table
	 * 
	 * @see  GenericDAO#insertIntoTable(String[], String[])
	 */
	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		this.insert("Doctor", fields, params);
		
	}
	
	
	/**
	 * deletes from table 
	 * 
	 * @see GenericDAO#deleteFromTable(String[], String[])
	 */
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("Doctor", fields, params);
	}
	
	
	/**
	 * gets data from the tabl e
	 * 
	 * @see GenericDAO#getData(String[], String[])
	 */
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

	/**
	 * updates that doctor 
	 * 
	 * @see GenericDAO#updateTable(String[], String[], String[], String[])
	 */
	@Override
	public void updateTable(String[] setFields, String[] setParams, String[] fields, String[] params)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
