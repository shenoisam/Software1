package backend.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.NotImplementedException;
import backend.classes.Appointment;
import backend.classes.Patient;

/**
 * PatientDAO accesses the patient table
 * 
 * 
 * @author samshenoi
 *
 */
public class PatientDAO extends GenericDAO{
	
	/**
	 * default constructor for the PatientDAO
	 * 
	 */
	public PatientDAO(){
		super();
	}
	
	/**
	 * get a Patient by id
	 * 
	 * @param id the id of the patient 
	 * @return the Patient
	 */
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
	
	/**
	 * logs in a patient by email and password
	 * 
	 * 
	 * @param email the email of the patient
	 * @param password the password of the patient
	 * @return the Patient
	 */
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
	
	/**
	 * gets all patients from database
	 * 
	 * @return a list of all patients
	 */
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
	
	/**
	 * defines a custom query to find patients meeting poplulation health parameters
	 * 
	 * 
	 * @param DoctorID DoctorID population health parameter
	 * @param Diagnosis Diagnosis population health parameter
	 * @param PrescriptionName Prescription population health parameter
	 * @param start starting age range
	 * @param end ending age range 
	 * @return
	 */
	public List<Patient> bigData(String DoctorID, String Diagnosis, String PrescriptionName, int start, int end) {
		String query = "SELECT * FROM PATIENT, USER WHERE Patient.ID = User.ID ";
		String di, dy, dz; 
		boolean d, y, z;
		d = y = z = false; 
		di = dy = dz = "";
		if (!DoctorID.contentEquals("")) {
			di = "Patient.ID IN ( SELECT PATIENTID FROM NOTES WHERE DOCTORID = ?)";
			d = true; 
		}
		if (!Diagnosis.contentEquals("")) {
			dy = "Patient.ID IN ( SELECT PATIENTID FROM PatientDiagnosis WHERE Diagnosis = ?)";
			y = true; 
		}
		if (!PrescriptionName.contentEquals("")) {
			dz = "Patient.ID IN ( SELECT PatientID FROM Prescription WHERE Name = ?)";
			z = true; 
		}
		int num = 0; 
		String [] params = new String [3];
		if(d && y && z) {
			query = query + " AND " + di + " AND " + dy + " AND " + dz;
			params[0] = DoctorID; 
			params[1] = Diagnosis; 
			params[2] = PrescriptionName; 
			num = 3;
		}else if (d && y) {
			query = query + " AND " + di + " AND " + dy;
			params[0] = DoctorID; 
			params[1] = Diagnosis; 
	
			num = 2;
		}else if(d && z) {
			query = query + " AND " + di + " AND " + dz;
			params[0] = DoctorID; 
			 
			params[1] = PrescriptionName; 
			num = 2; 
		}else if(d) {
			query = query + " AND " + di;
			params[0] = DoctorID; 
		
			num =1 ; 
		}else if(y && z) {
			query = query  + " AND " + dy + " AND " + dz;
		 
			params[0] = Diagnosis; 
			params[1] = PrescriptionName; 
			num =2;
		}else if(y) {
			query = query + " AND " + dy ;
 
			params[0] = PrescriptionName; 
			num =1; 
		}else if (z){
			query = query + " AND " + dz;
	 
			params[0] = PrescriptionName; 
			num =1;
		}
	
		return generateList(bigdataquery(query,params, num));
	
	}

	 /**
     * Inserts into patient
     * 
     * @see GenericDAO#insertIntoTable(String[], String[])
     */
	@Override
	public void insertIntoTable(String[] fields, String[] params) throws SQLException {
		this.insert("Patient", fields, params);
		
	}
	
	/**
	 * deletes from the patient table
	 * 
	 * @see GenericDAO#deleteFromTable(String[], String[])
	 */
	@Override
	public void deleteFromTable(String[] fields, String[] params) throws SQLException {
		this.delete("Patient", fields, params);
		
	}
	
	/**
	 * gets data from Patient
	 * 
	 * @see GenericDAO#getData(String[], String[])
	 */
	@Override
	public List<Patient> getData(String[] fields, String[] params) {
		String rmStr = "";
		if (fields.length > 0) {
	    	for (int i = 0; i < fields.length; i++) {
	    
		    	if(fields[i].contentEquals("ID")) {
		    		fields[i] = "Patient.ID";
		    	}
		    }
		    rmStr = this.generateRmStr(fields, params);
		    rmStr = rmStr + "AND Patient.ID = User.ID";
	    }
		
	    if(fields.length > 0) {
	    	rmStr = this.generateRmStr(fields, params);
	    	rmStr = rmStr + "AND Patient.ID = User.ID";
	    }else {
	    	rmStr = " WHERE Patient.ID = User.ID";
	    }
	
		List<List<Object>> stuff = this.query("*", "Patient, User", rmStr, params);
		return generateList(stuff);
	}

	/**
	 * updates Patient
	 * 
	 * @see GenericDAO#updateTable(String[], String[], String[], String[])
	 */
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
