package backend.factory;

import java.util.List;

import backend.classes.Diagnosis;

public class DiagnosisObject implements FactoryObjects<Diagnosis> {

	@Override
	public Diagnosis generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new Diagnosis(headerList, list);
	}

}
