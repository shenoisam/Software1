package backend.dao;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import backend.NotImplementedException;
import backend.classes.*;
public class AppointmentDAO extends GenericDAO {
	AppointmentDAO(){
		super();
	}
	
	/*
	 * 
	 * 
	 * 
	 */
	 public List<Appointment> getAppointments(String [] fields, String [] params) throws NotImplementedException{
		 String rmStr = " ";
		 
		 for (int i =0; i < fields.length - 1; i++) {
			 rmStr = rmStr +" " + fields[i] + " = ? AND"; 
		 }
		 rmStr = rmStr + fields[fields.length -1] + " = ? ";
		 
		 List<List<Object>> stuff = this.query("*", "Appointment", rmStr, params);
		 return generateList(stuff);
		
	 }

	public List<Appointment> getAllAppointmentsByDate(Date date) throws NotImplementedException{
		String select = "p.FirstName, p.LastName, d.FirstName, d.LastName, a.Date";
		String table = "User p, Doctor d, Appointment a";
		String rmStr = "a.DoctorID = d.ID AND a.PatientID = p.ID AND a.Date = ?";
		
		// This might not work
		String [] params = {date.toString()};
		List<List<Object>> data = this.query(select, table, rmStr, params);
		
		return generateList(data);
	}
	
	private List<Appointment> generateList(List<List<Object>> stuff) throws NotImplementedException{
		 List<Appointment> finalList = new ArrayList<Appointment>(); 
		 for(int i = 0; i < stuff.size(); i++) {
			 //TODO: implement this; 
			 finalList.add(new Appointment(stuff.get(i)));
		 }
		 
		 return finalList;
	}
	
	@Override
	public void updateTable(String[] fields, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertIntoTable(String[] fields, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFromTable(String[] fields, String[] params) {
		// TODO Auto-generated method stub
		
	}


}
