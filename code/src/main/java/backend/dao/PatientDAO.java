package backend.dao;

import java.sql.SQLException;
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

		List<List<Object>> data = this.query("*","Patient, User"," WHERE Patient.ID = User.ID AND User.ID = ?", params);

		// If we are getting the doctor by id, there should only always be only 0..1 doctors
	    // with this id
	    assert(data.size() < MAX_SINGLET_DATA_SIZE);
	    if(data.size() > MIN_DATA_SIZE) {
			List<Object> pat = data.get(1); 
			s = new Patient(listToString(data.get(0)), pat);
		}
		return s; 		
				
	}
	public Patient getPatient(String email, String password) {
		Patient s = null; 
		String [] params = {email, password};
		List<List<Object>> data = this.query("*","Patient, User"," WHERE Patient.ID = User.ID AND Email = ? AND Password = MD5(?)", params);
		// If we are getting the doctor by id, there should only always be only 0..1 doctors
	    // with this id
	    assert(data.size() < MAX_SINGLET_DATA_SIZE);
	    if(data.size() > MIN_DATA_SIZE) {
			List<Object> pat = data.get(1); 
			s = new Patient(listToString(data.get(0)), pat);
		}
		return s; 		
				
	}
	public List<Patient> getAllPatients() {
		String select = "Firstname, LastName, DOB, Gender, Race, Ethnicity, MaritalStatus";
		String table = "Patient, User";

		String rmStr = " WHERE Patient.ID = User.ID";
		
		String [] params = {};
		return generateList(this.query(select, table, rmStr, params)); 
	}
	private List<Patient> generateList(List<List<Object>> stuff){
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
	
	public List<Patient> bigData(String DoctorID, String Diagnosis, String PrescriptionName, int start, int end) throws SQLException{
		String query = "SELECT * FROM PATIENT";
		String di, dy, dz; 
		boolean d, y, z;
		d = y = z = false; 
		di = dy = dz = "";
		if (!DoctorID.contentEquals("")) {
			di = "ID IN ( SELECT PATIENTID FROM NOTES WHERE DOCTORID = ?)";
			d = true; 
		}
		if (!Diagnosis.contentEquals("")) {
			dy = "ID IN ( SELECT PATIENTID FROM PatientDiagnosis WHERE Diagnosis = ?)";
			y = true; 
		}
		if (!PrescriptionName.contentEquals("")) {
			dz = "ID IN ( SELECT PatientID FROM Prescription WHERE Name = ?)";
			z = true; 
		}
		int num = 0; 
		String [] params = new String [3];
		if(d && y && z) {
			query = query + " WHERE " + di + " AND " + dy + " AND " + dz;
			params[0] = DoctorID; 
			params[1] = Diagnosis; 
			params[2] = PrescriptionName; 
			num = 3;
		}else if (d && y) {
			query = query + "WHERE " + di + " AND " + dy;
			params[0] = DoctorID; 
			params[1] = Diagnosis; 
	
			num = 2;
		}else if(d && z) {
			query = query + "WHERE " + di + " AND " + dz;
			params[0] = DoctorID; 
			 
			params[1] = PrescriptionName; 
			num = 2; 
		}else if(d) {
			query = query + "WHERE " + di;
			params[0] = DoctorID; 
		
			num =1 ; 
		}else if(y && z) {
			query = query + "WHERE " + dy + " AND " + dz;
		 
			params[0] = Diagnosis; 
			params[1] = PrescriptionName; 
			num =2;
		}else if(y) {
			query = query + "WHERE " + dy ;
 
			params[0] = PrescriptionName; 
			num =1; 
		}else if (z){
			query = query + "WHERE " + dz;
	 
			params[0] = PrescriptionName; 
			num =1;
		}
		
	   return generateList(bigdataquery(query,params, num));
	}

	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		this.insert("Patient", fields, params);
		
	}
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {
		this.delete("Patient", fields, params);
		
	}
	@Override
	public List<Patient> getData(String[] fields, String[] params) {
	    for (int i = 0; i < fields.length; i++) {
	    	if(fields[i].contentEquals("ID")) {
	    		fields[i] = "Patient.ID";
	    	}
	    }
	    
	    String rmStr = this.generateRmStr(fields, params);
	
		rmStr = rmStr + "AND Patient.ID = User.ID";
		List<List<Object>> stuff = this.query("*", "Patient, User", rmStr, params);
		return generateList(stuff);
	}

	@Override
	public void updateTable(String[] setFields, String[] setParams, String[] fields, String[] params)
			throws SQLException {
		for(int i =0; i < setFields.length;i++) {
			if (setFields[i].contentEquals("DOB")) {
				setParams[i] = new java.sql.Date(new java.util.Date(setParams[i]).getTime()).toString();
			}
		}
		String rmStr = this.generateRmStr(fields, params);
		this.update("Patient", setFields, rmStr, setParams);
		
	}
	
	

	
}
