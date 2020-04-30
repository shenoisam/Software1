package backend.factory;

import java.util.List;

import backend.classes.Doctor;

public class DoctorObject implements FactoryObjects<Doctor> {

	@Override
	public Doctor generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new Doctor(headerList, list);
	}

}
