package backend.factory;

import java.util.List;

import backend.classes.PatientDiagnosis;

public class PatientDiagnosisObject implements FactoryObjects<PatientDiagnosis> {

	@Override
	public PatientDiagnosis generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new PatientDiagnosis(headerList, list);
	}

}
