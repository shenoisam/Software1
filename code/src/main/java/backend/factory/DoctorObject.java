package backend.factory;

import java.util.List;

import backend.classes.Doctor;

public class DoctorObject implements FactoryObjects<Doctor> {

	/**
	 * Defines a Doctor factory class
	 * 
	 * 
	 * @author katiewokoek
	 *
	 */
	
	/**
	 * creates a new instance of a Doctor object
	 * 
	 * @param headerList the list of header items
	 * @param list the list of object items
	 * 
	 * @return returns a new instance of a Doctor object
	 */
	@Override
	public Doctor generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new Doctor(headerList, list);
	}

}
