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
		User u2  = null; 
		String [] params = {email,password};
		List<List<Object>> data = this.query("*","User","Email = ? AND Password = MD5(?)", params);
		// If we are getting the doctor by id, there should only always be only 0..1 doctors
	    // with this id
	    assert(data.size() < MAX_SINGLET_DATA_SIZE);
	   
	    if(data.size() > MIN_DATA_SIZE) {
	    	u2 = new User(listToString(data.get(0)),data.get(1));
	    	System.out.println(u2);
	    	String id = u2.getID(); 
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
			
			if(u != null) {
				u.setUserInfo(u2);
			}
			
	    }
	
		return u; 
	}

	@Override
	public void updateTable(String[] fields, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		this.insert("User", fields, params);
		
	}
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("User", fields, params);
	}
	

}
