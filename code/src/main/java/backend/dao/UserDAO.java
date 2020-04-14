package backend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import backend.SQLConnection.SQLConnection;
import backend.SQLConnection.SQLConnectionPool;
import backend.SQLConnection.SQLConnectionPoolFactory;
import backend.classes.Staff;
import backend.classes.User;

/**
 * Defines a class that allows for saving and accessing of user information 
 * 
 * 
 * @author samshenoi
 *
 */
public class UserDAO extends GenericDAO{
	
	public UserDAO(){
		super();
	}
	
	public User LogInUser(String email, String password) {
		User u = null; 
		
		String [] params = {email,password};
		List<List<Object>> data = this.query("ID","User","Email = ? AND Password = MD5(?)", params);
		// If we are getting the doctor by id, there should only always be only 0..1 doctors
	    // with this id
	    assert(data.size() < MAX_SINGLET_DATA_SIZE);
	   
	    if(data.size() > MIN_DATA_SIZE) {
	    	String id = data.get(1).get(0).toString();
	    	//TODO: redo this part. its not very good code
			PatientDAO p = new PatientDAO();
			u = p.getPatient(id); 
			if (u == null) {
				StaffDAO s = new StaffDAO();
				u = s.getStaff(id);
				if (u == null) {
					DoctorDAO d = new DoctorDAO();
					u = d.getDoctor(id);
				}
			}
	    }
		
		return u; 
	}
	

}
