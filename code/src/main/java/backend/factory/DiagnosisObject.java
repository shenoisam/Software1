package backend.factory;

import java.util.List;

import backend.classes.Diagnosis;

public class DiagnosisObject implements FactoryObjects<Diagnosis> {

	/**
	 * Defines a Diagnosis factory class
	 * 
	 * 
	 * @author katiewokoek
	 *
	 */
	
	/**
	 * creates a new instance of a Diagnosis object
	 * 
	 * @param headerList the list of header items
	 * @param list the list of object items
	 * 
	 * @return returns a new instance of a Diagnosis object
	 */
    @Override
	public Diagnosis generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new Diagnosis(headerList, list);
	}

}
