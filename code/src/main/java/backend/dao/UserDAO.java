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
 * UserDAO connects to the User table in the database
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


	 /**
     * Inserts into User
     * 
     * @see GenericDAO#insertIntoTable(String[], String[])
     */
	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		this.insert("User", fields, params);
		
	}
	/**
	 * deletes from the user table
	 * 
	 * @see GenericDAO#deleteFromTable(String[], String[])
	 */
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {		
		this.delete("User", fields, params);
	}


	/**
	 * gets data from User
	 * 
	 * @see GenericDAO#getData(String[], String[])
	 */
	@Override
	public <T> List<T> getData(String[] fields, String[] params) {
		
		return null;
	}

	/**
	 * updates User
	 * 
	 * @see GenericDAO#updateTable(String[], String[], String[], String[])
	 */
	@Override
	public void updateTable(String[] setFields, String[] setParams, String[] fields, String[] params)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}
	

}
