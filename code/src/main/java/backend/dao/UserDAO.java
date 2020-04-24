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
    	//TODO: redo this part. its not very good code
		PatientDAO p = new PatientDAO();
		u = p.getPatient(email,password); 
		if (u == null) {
			StaffDAO s = new StaffDAO();
			u = s.getStaff(email,password);
			if (u == null) {
				DoctorDAO d = new DoctorDAO();
				u = d.getDoctor(email,password);
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

	@Override
	public <T> List<T> getData(String[] fields, String[] params) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
