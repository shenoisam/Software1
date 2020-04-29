package backend.factory;

import java.util.List;

import backend.classes.Patient;

public class PatientObject implements FactoryObjects {

	@Override
	public Patient generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new Patient(headerList, list);
	}

}
