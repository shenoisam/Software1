package backend.dao;

import java.util.List;
import backend.classes.Doctor;


public class DoctorDAO extends GenericDAO{
	//SQLConnectionPool p; 
	public DoctorDAO(){
		super();
	}
	public Doctor getDoctor(String id) {
		Doctor s = null; 
		String [] params = {id};
	    List<List<Object>> data = this.query("*","Doctor","ID = ?", params);
		// If we are getting the doctor by id, there should only always be only 0..1 doctors
	    // with this id
	    assert(data.size() < MAX_SINGLET_DATA_SIZE);
	    if(data.size() > MIN_DATA_SIZE) {
			List<Object> doc = data.get(1); 
			//TODO: need to check to make sure that we are placing in the right columns
			s = new Doctor(doc.get(0).toString(), doc.get(1).toString());
		}
		return s; 		
				
	}

}
