package backend.dao;

import java.sql.SQLException;
import java.util.List;
import backend.classes.Doctor;


public class DoctorDAO extends GenericDAO{
	//SQLConnectionPool p; 
	public DoctorDAO(){
		super();
	}
	public Doctor getDoctor(String id) {
		Doctor s = null; 
		String [] params = {id};
	    List<List<Object>> data = this.query("*","Doctor, User "," Doctor.ID = User.ID AND User.ID = ?", params);
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
	    List<List<Object>> data = this.query("*","Doctor, User "," Doctor.ID = User.ID AND User.Email = ? AND User.Password = MD5(?)", params);
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
	public void updateTable(String[] fields, String[] params) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		this.insert("Doctor", fields, params);
		
	}
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("Doctor", fields, params);
	}

}
