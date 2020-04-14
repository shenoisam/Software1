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
	SQLConnectionPool p; 
	public StaffDAO(){
		p = SQLConnectionPoolFactory.getPool();
	}
	public Staff getStaff(String id) {
		Staff s = null; 
		String [] params = {id};
		List<List<Object>> data = this.query("*","Patient","ID = ?", params);
		// If we are getting the doctor by id, there should only always be only 0..1 doctors
	    // with this id
	    assert(data.size() < MAX_SINGLET_DATA_SIZE);
	    if(data.size() > MIN_DATA_SIZE) {
			List<Object> staff = data.get(1); 
			//TODO: implement new patient for all columns and check for null columns. 
			s = new Staff(staff.get(0).toString(),staff.get(1).toString());
		}
		return s; 		
				
	}
	
	

}
