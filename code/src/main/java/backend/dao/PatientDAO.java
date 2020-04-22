package backend.dao;

import java.util.ArrayList;
import java.util.List;

import backend.NotImplementedException;
import backend.classes.Appointment;
import backend.classes.Patient;

public class PatientDAO extends GenericDAO{
	public PatientDAO(){
		super();
	}
	public Patient getPatient(String id) {
		Patient s = null; 
		String [] params = {id};
		List<List<Object>> data = this.query("*","Patient","ID = ?", params);
		// If we are getting the doctor by id, there should only always be only 0..1 doctors
	    // with this id
	    assert(data.size() < MAX_SINGLET_DATA_SIZE);
	    if(data.size() > MIN_DATA_SIZE) {
			List<Object> pat = data.get(1); 
			//TODO: implement new patient for all columns and check for null columns. 
			
			
			// Hey we should probably switch this constructor call to just passing in pat,
			// that way we're sending in all of the patient's values as a list of objects
			s = new Patient(pat.get(0).toString());
		}
		return s; 		
				
	}
	public List<Patient> getAllPatients() throws NotImplementedException{
		String select = "Firstname, LastName, DOB, Gender, Race, Ethnicity, MaritalStatus";
		String table = "Patient, User";
		String rmStr = "Patient.ID = User.ID";
		String [] params = {};
		return generateList(this.query(select, table, rmStr, params)); 
	}
	private List<Patient> generateList(List<List<Object>> stuff) throws NotImplementedException{
		 List<Patient> finalList = new ArrayList<Patient>(); 
		 List<String> headerRow = new ArrayList<String>(); 
		 for (Object o: stuff.get(0)) {
			 headerRow.add(o.toString());
		 }
		 for(int i = 1; i < stuff.size(); i++) {
			 //TODO: implement this; 
			 finalList.add(new Patient(headerRow,stuff.get(i)));
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
