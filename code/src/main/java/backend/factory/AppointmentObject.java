package backend.factory;

import java.util.List;

import backend.classes.Appointment;

public class AppointmentObject implements FactoryObjects<Appointment> {

	@Override
	public Appointment generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		
		return new Appointment(headerList, list);
	}

}
