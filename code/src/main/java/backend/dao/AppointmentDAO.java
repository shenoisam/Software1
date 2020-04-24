package backend.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import backend.NotImplementedException;
import backend.classes.*;
import backend.dao.GenericDAO;


/**
 * Defines a Database Access Object (DAO) specific for connecting to the Appointment Table 
 * 
 * 
 * @author samshenoi
 *
 */
public class AppointmentDAO extends GenericDAO {
	public AppointmentDAO(){
		super();
	}
	
	/*
	 * gets appointments based solely on fields in Appointment table (Date, DoctorID, PatientID) 
	 * does not perform any joining with the user table or any other table. 
	 * 
	 * @param fields the fields to be used to search for. Can be either (Date, DoctorID, or PatientID) or a subset of those. 
	 * @param params the values to be matched against the fields. Must be in the same order and orientation as the fields array.
	 * @return returns a List of appointments representing the rows returned from the table 
	 */
	 public List<Appointment> getData(String[] fields, String[] params) {
		 String rmStr = this.generateRmStr(fields, params);
		 
		 List<List<Object>> stuff = this.query("*", "Appointment", rmStr, params);
		 return generateList(stuff);
		
	 }

	/*
	 * gets all appointments that fall on a singular date for any doctor or patient 
	 * 
	 * @params date the date to be checked against 
	 * @return returns the a List of Appointments representing the rows returned from the table 
	 */
	public List<Appointment> getAllAppointmentsByDate(Date date) {
		String select = "p.FirstName, p.LastName, d.FirstName, d.LastName, a.Date AS DateVal, DoctorID, PatientID";
		String table = "User p, User d, Appointment a";
		String rmStr = "a.DoctorID = d.ID AND a.PatientID = p.ID AND a.Date = ?";
		
		// This might not work
		String [] params = {new java.sql.Date(date.getTime()).toString()};
		List<List<Object>> data = this.query(select, table, rmStr, params);
		
		return generateList(data);
	}
	
	/*
	 * gets all appointments that fall on a singular date for any doctor or patient 
	 * 
	 * @params date the date to be checked against 
	 * @return returns the a List of Appointments representing the rows returned from the table 
	 */
	public List<Appointment> getAllDoctorsAppointmentsByDate(Date date, Doctor d) {
		String select = "p.FirstName, p.LastName, d.FirstName, d.LastName, a.Date AS DateVal, DoctorID, PatientID";
		String table = "User p, User d, Appointment a";
		String rmStr = "a.DoctorID = d.ID AND a.PatientID = p.ID AND a.Date = ? AND d.ID";
		
		// This might not work
		String [] params = {new java.sql.Date(date.getTime()).toString(), d.getID()};
		List<List<Object>> data = this.query(select, table, rmStr, params);
		
		return generateList(data);
	}
	
	private List<Appointment> generateList(List<List<Object>> stuff) {
		 List<Appointment> finalList = new ArrayList<Appointment>(); 
		 List<String> headerRow = new ArrayList<String>(); 
		 for (Object o: stuff.get(0)) {
			 headerRow.add(o.toString());
		 }
		 for(int i = 1; i < stuff.size(); i++) {
			 //TODO: implement this; 
			 finalList.add(new Appointment(headerRow, stuff.get(i)));
		 }
		 
		 return finalList;
	}
	
	/*
	 * gets all appointments that fall within a date range
	 * 
	 * @params date1 the lower bound of the date range 
	 * @params date2 the upper bound of the date range
	 * @return returns the a List of Appointments representing the rows returned from the table 
	 */
	public List<Appointment> getAllAppointmentsByDateRange(Date date1, Date date2) throws NotImplementedException{
		String select = "p.FirstName, p.LastName, d.FirstName, d.LastName, a.Date";
		String table = "User p, Doctor d, Appointment a";
		String rmStr = "a.DoctorID = d.ID AND a.PatientID = p.ID AND a.Date > ? AND a.Date < ?";
		
		String [] params = {new java.sql.Date(date1.getTime()).toString(), new java.sql.Date(date2.getTime()).toString()};
		
        List<List<Object>> data = this.query(select, table, rmStr, params);
		
		return generateList(data);
	}
	
	/*
	 * updates the Appointment table 
	 * 
	 * @see GenericDAO#updateTable
	 */
	@Override
	public void updateTable(String[] fields, String[] params) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * inserts into the Appointment table 
	 * 
	 * @see GenericDAO#insertIntoTable
	 */
	@Override 
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		params[0] =  new java.sql.Date(new Date(params[0]).getTime()).toString();
		this.insert("Appointment", fields, params);
		
	}

	/*
	 * deletes from the Appointment table 
	 * 
	 * @see GenericDAO#deleteFromTable
	 */
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {
		params[0] = new java.sql.Date(new Date(params[0]).getTime()).toString();
		this.delete("Appointment", fields, params);
	}


}
