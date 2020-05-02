package backend.factory;

import java.util.List;

import backend.classes.Patient;

public class PatientObject implements FactoryObjects<Patient> {
	
	/**
	 * Defines a Patient factory class
	 * 
	 * 
	 * @author katiewokoek
	 *
	 */
	
	/**
	 * creates a new instance of a Patient object
	 * 
	 * @param headerList the list of header items
	 * @param list the list of object items
	 * 
	 * @return returns a new instance of a Patient object
	 */

	@Override
	public Patient generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new Patient(headerList, list);
	}

}
