package backend.dao;

import java.util.List;
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
			s = new Patient(pat.get(0).toString());
		}
		return s; 		
				
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
