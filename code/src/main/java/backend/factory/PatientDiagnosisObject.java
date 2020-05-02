package backend.factory;

import java.util.List;

import backend.classes.PatientDiagnosis;

public class PatientDiagnosisObject implements FactoryObjects<PatientDiagnosis> {
	
	/**
	 * Defines a PatientDiagnosis factory class
	 * 
	 * 
	 * @author katiewokoek
	 *
	 */
	
	/**
	 * creates a new instance of a PatientDiagnosis object
	 * 
	 * @param headerList the list of header items
	 * @param list the list of object items
	 * 
	 * @return returns a new instance of a PatientDiagnosis object
	 */

	@Override
	public PatientDiagnosis generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new PatientDiagnosis(headerList, list);
	}

}
