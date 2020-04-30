package backend.dao;


import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import backend.NotImplementedException;
import backend.classes.*;
import backend.dao.GenericDAO;
import backend.factory.AppointmentObject;
import backend.factory.FactoryObjects;


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
		 String rmStr;
		 if(fields.length > 0 && params.length > 0) {
			 rmStr = this.generateRmStr(fields, params);
		 } else {
			 rmStr = "";
		 }
		 
		 String rmStr = this.generateRmStr(fields, params);
		 LocalDateTime d = null; 
		 int ndx = -1; 
		 // Hacky way to ensure that we get a noice date range 
		 boolean searchByDate = false; 
		 for(int i = 0; i < fields.length && ! searchByDate; i++){
			 if(fields[i].contentEquals("DateVal")) {
				 searchByDate = true; 
				 d = LocalDateTime.parse(params[i]);
				 ndx = i; 
			 }
		 }
		 if(rmStr != null) {
			 rmStr = rmStr + " ORDER BY DateVal";
		 }
		 
		 List<List<Object>> stuff;
		 if (searchByDate) {
			 Date d1 = Date.from( d.atZone( ZoneId.systemDefault()).toInstant());
			 Date d2 = Date.from( d.atZone( ZoneId.systemDefault()).toInstant());
			 d1.setDate(d1.getDate() - 1);
			 d2.setDate(d2.getDate() + 1);
			 List<String> newFields = new ArrayList<String>(); 
			 List<String> newParams = new ArrayList<String>(); 
			 for (int y = 0; y < fields.length; y++) {
				 if(y != ndx) {
					 newFields.add(fields[y]);
					 newParams.add(params[y]);
				 }
			 }
			 
			 String [] f = Arrays.asList(newFields.toArray()).toArray(new String[newFields.toArray().length]);
			 String [] p = Arrays.asList(newParams.toArray()).toArray(new String[newParams.toArray().length]);
			 stuff = getAllAppointmentsByDateRange(d1, d2, f, p);
		 }else {
		    stuff = this.query("*", "Appointment", rmStr, params);
		 }
		 
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
		String rmStr = " WHERE a.DoctorID = d.ID AND a.PatientID = p.ID AND a.Date > ?";
		
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
		String select = "p.FirstName, p.LastName, d.FirstName, d.LastName, a.DateVal AS DateVal, DoctorID, PatientID";
		String table = "User p, User d, Appointment a";
		String rmStr = " WHERE a.DoctorID = d.ID AND a.PatientID = p.ID AND a.Date = ? AND d.ID";
		
		// This might not work
		String [] params = {new java.sql.Date(date.getTime()).toString(), d.getID()};
		List<List<Object>> data = this.query(select, table, rmStr, params);
		//FactoryObjects<Appointment> factoryObj = new AppointmentObject();
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
	public List<List<Object>> getAllAppointmentsByDateRange(Date date1, Date date2, String [] fields, String [] params) {
		String select = "p.FirstName, p.LastName, d.FirstName, d.LastName, a.DateVal, a.DoctorID AS DoctorID, a.PatientID AS PatientID";
		String table = "User p, User d, Appointment a";
		String rmStr = " WHERE a.DoctorID = d.ID AND a.PatientID = p.ID AND a.DateVal > ? AND a.DateVal < ?";// + generateRmStr(fields, params);
		
		List<String> par = new ArrayList<String>(); 
		par.add(new java.sql.Date(date1.getTime()).toString());
		par.add( new java.sql.Date(date2.getTime()).toString());
		for(String z: params ) {
			par.add(z);
		}
		
        List<List<Object>> data = this.query(select, table, rmStr, Arrays.asList(par.toArray()).toArray(new String[par.toArray().length]));
		
		return data;
	}
	
	/*
	 * updates the Appointment table 
	 * 
	 * @see GenericDAO#updateTable
	 */
	@Override
	public void updateTable(String[] setFields, String[] setParams, String [] fields, String [] params ) throws SQLException {
		String rmStr = this.generateRmStr(fields, params);
		this.update("Appointment", setFields, rmStr, setParams);
		
	}

	/*
	 * inserts into the Appointment table 
	 * 
	 * @see GenericDAO#insertIntoTable
	 */
	@Override 
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		/*for (int i =0; i < fields.length; i++) {
			if (fields[i] == "DateVal") {

				params[i] =  java.sql.Date.valueOf( LocalDateTime.parse(params[i]) );
			}
		}*/
		
		this.insert("Appointment", fields, params);
		
	}

	/*
	 * deletes from the Appointment table 
	 * 
	 * @see GenericDAO#deleteFromTable
	 */
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {
		for (int i =0; i < fields.length; i++) {
			if (fields[i] == "DateVal") {
				params[i] =  new java.sql.Date(new Date(params[i]).getTime()).toString();
			}
		}

		this.delete("Appointment", fields, params);
	}


}
