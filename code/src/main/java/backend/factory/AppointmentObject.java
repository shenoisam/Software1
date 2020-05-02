package backend.factory;

import java.util.List;

import backend.classes.Appointment;

public class AppointmentObject implements FactoryObjects<Appointment> {

	/**
	 * Defines an Appointment factory class
	 * 
	 * 
	 * @author katiewokoek
	 *
	 */
	
	/**
	 * creates a new instance of an Appointment object
	 * 
	 * @param headerList the list of header items
	 * @param list the list of object items
	 * 
	 * @return returns a new instance of an Appointment object
	 */
	@Override
	public Appointment generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		
		return new Appointment(headerList, list);
	}

}
