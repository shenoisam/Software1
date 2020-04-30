package backend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.SQLConnection.SQLConnection;
import backend.SQLConnection.SQLConnectionPool;
import backend.SQLConnection.SQLConnectionPoolFactory;
import backend.classes.Doctor;
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
		List<List<Object>> data = this.query("*","Staff, User"," WHERE User.ID = Staff.ID AND Email = ? AND Password = MD5(?)", params);
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
	@Override
	public List<Staff> getData(String[] fields, String[] params) {
	    for (int i = 0; i < fields.length; i++) {
	    	if(fields[i].contentEquals("ID")) {
	    		fields[i] = "Staff.ID";
	    	}
	    }
		    String rmStr = this.generateRmStr(fields, params);
			rmStr = rmStr + "AND Staff.ID = User.ID";
			List<List<Object>> stuff = this.query("*", "Staff, User", rmStr, params);
			List<Staff> d = new ArrayList<Staff>(); 
			if (stuff.size() > MIN_DATA_SIZE) {
				//Get the header row. The first row returned should be the header row
				List<Object> header = stuff.get(0);
				List<String> headerRow  = new ArrayList<String> (); 
				
				for (Object h: header) {
					headerRow.add(h.toString());
				}
				for(int i = MIN_DATA_SIZE; i < stuff.size(); i++) {
					d.add(new Staff(headerRow, stuff.get(i)));
				}
			}
			return d; 
	}
	

}
