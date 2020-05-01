package businesslayer;

import backend.dao.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import backend.classes.*;

/**
 * Defines a facade that allows for connection to the database via DAOs. Same interface is used for accessing all 
 * DAOS
 * 
 * 
 * @author samshenoi
 *
 */
public class ProviderService {
    Map<CShareObjects, GenericDAO> daos; 
	public ProviderService(){
		daos = new HashMap<CShareObjects, GenericDAO>(); 
	}
	
	/*
	 * This function gets data from the database. 
	 * 
	 * @param classname A CShareObjects value describing which class needs to be queried against 
	 * @param fields A String [] containing the fields used for the query 
	 * @param params A String [] containing the parameter values used for the query
	 * @return a List containing the data type needed 
	 * 
	 */
	public <T> List<T> getData(CShareObjects classname, String [] fields, String [] params){
		if (!daos.containsKey(classname)) {
			// Need to either build a factory or do something with this 
			 daos.put(classname, getDAOfromClassName(classname));
		}
		
		return daos.get(classname).getData(fields, params);
	}
	

	private GenericDAO getDAOfromClassName(CShareObjects classname) {
		GenericDAO g = null; 
		switch (classname) {
		case APPOINTMENT: g = new AppointmentDAO(); break; 
		case DIAGNOSIS : g = new DiagnosisDAO(); break; 
		case DOCTOR: g = new DoctorDAO();  break; 
		case NOTES : g = new NotesDAO(); break; 
		case PATIENT :g = new PatientDAO(); break; 
		case PATIENTDIAGNOSIS: g = new PatientDiagnosisDAO(); break; 
		case PRESCRIPTION :g =  new PrescriptionDAO(); break; 
		case STAFF : g = new StaffDAO(); break; 
		case TEST : g = new TestDAO(); break;  
		case TESTORDER: g = new TestOrderDAO(); break; 
		case TESTRESULT: g = new TestResultDAO(); break; 
		case USER: g = new UserDAO(); break; 
		}
		return g; 
	}
	
	/*
	 * Inserts into the database
	 * 
	 * @param classname A CShareObject pointing to the class where data needs to be inserted 
	 * @param fields A String [] containing the fields that data will be inserted to 
	 * @param params A String [] containing the parameters that will be inserted into the database
	 * @return a boolean value indicating the success or failure of the database insertion
	 * 
	 */
	public boolean insert(CShareObjects classname, String [] fields, String [] params) {
		if (!daos.containsKey(classname)) {
			// Need to either build a factory or do something with this 
			 daos.put(classname, getDAOfromClassName(classname));
		}
	    boolean success = true;
		try {
			daos.get(classname).insertIntoTable(fields, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			success = false; 
		}
		return success; 
	}
	
	/*
	 * Special query designed for population health information
	 * 
	 * @param DoctorID the id of the doctor that we are looking for 
	 * @param Diagnosis a Diagnosis that we will use for population health parameters
	 * @param PrescriptionName a prescription name used for population health parameters
	 * @return a list of patient data
	 * 
	 */
    public List<Patient> bigDataQuery(String DoctorID, String Diagnosis, String PrescriptionName){
    	if (!daos.containsKey(CShareObjects.PATIENT)) {
			// Need to either build a factory or do something with this 
			 daos.put(CShareObjects.PATIENT, getDAOfromClassName(CShareObjects.PATIENT));
		}
	    boolean success = true;
		
	    PatientDAO d = (PatientDAO) daos.get(CShareObjects.PATIENT);
			
	    
		return d.bigData(DoctorID, Diagnosis,PrescriptionName, 0,0);
		
	
    }
    
	/*
	 * Updates the documents in the database (Pretty much only used for patient) 
	 * 
	 * @param classname A CShareObject pointing to the class where data needs to be updated
	 * @param fields A String [] containing the fields that data will need to be matched for update 
	 * @param params A String [] containing the parameters that will need to be matched for update
	 * @param setFields a String [] containing the fields that will be changed to a value 
	 * @param sp a String [] containing the values that the matched documents will be changed to
	 * 
	 */
	public void update(CShareObjects patient, String[] setFields, String[] sp, String[] fields, String[] params) {
		if (!daos.containsKey(patient)) {
			// Need to either build a factory or do something with this 
			 daos.put(patient, getDAOfromClassName(patient));
		}
	    boolean success = true;
		try {
			daos.get(patient).updateTable(setFields, sp, fields, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			success = false; 
		}
		
	}
	

}
