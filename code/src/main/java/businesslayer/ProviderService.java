package businesslayer;

import backend.dao.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import backend.classes.*;

public class ProviderService {
    Map<CShareObjects, GenericDAO> daos; 
	public ProviderService(){
		daos = new HashMap<CShareObjects, GenericDAO>(); 
	}
	
	// This is such as bad way to do this
	public <T> List<T> getData(CShareObjects classname, String [] fields, String [] params){
		if (!daos.containsKey(classname)) {
			// Need to either build a factory or do something with this 
			 daos.put(classname, getDAOfromClassName(classname));
		}
		
		return daos.get(classname).getData(fields, params);
	}
	
	//Convert this to a factory maybe... Hacky way for now
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
	
	

}
