package backend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import backend.SQLConnection.SQLConnection;
import backend.SQLConnection.SQLConnectionPool;
import backend.SQLConnection.SQLConnectionPoolFactory;
import backend.classes.Patient;
import backend.classes.Staff;

public class StaffDAO extends GenericDAO{
	
	public StaffDAO(){
		super();
	}
	public Staff getStaff(String id) {
		Staff s = null; 
		String [] params = {id};
		List<List<Object>> data = this.query("*","Staff, User","User.ID = Staff.ID AND User.ID = ?", params);
		// If we are getting the doctor by id, there should only always be only 0..1 doctors
	    // with this id
	    assert(data.size() < MAX_SINGLET_DATA_SIZE);
	    if(data.size() > MIN_DATA_SIZE) {
			
			s = new Staff(listToString(data.get(0)),data.get(1));
	
		}
		return s; 		
				
	}
	public Staff getStaff(String email, String password) {
		Staff s = null; 
		String [] params = {email, password};
		List<List<Object>> data = this.query("*","Staff, User","User.ID = Staff.ID AND Email = ? AND Password = MD5(?)", params);
		// If we are getting the doctor by id, there should only always be only 0..1 doctors
	    // with this id
	    assert(data.size() < MAX_SINGLET_DATA_SIZE);
	    if(data.size() > MIN_DATA_SIZE) {
			
			s = new Staff(listToString(data.get(0)),data.get(1));
	
		}
		return s; 		
				
	}
	@Override
	public void updateTable(String[] fields, String[] params) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		this.insert("Staff", fields, params);
		
	}
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("Staff", fields, params);
	}
	

}
