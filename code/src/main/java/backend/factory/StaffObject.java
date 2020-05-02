package backend.factory;

import java.util.List;

import backend.classes.Staff;

public class StaffObject implements FactoryObjects<Staff> {
	
	/**
	 * Defines a Staff factory class
	 * 
	 * 
	 * @author katiewokoek
	 *
	 */
	
	/**
	 * creates a new instance of a Staff object
	 * 
	 * @param headerList the list of header items
	 * @param list the list of object items
	 * 
	 * @return returns a new instance of a Staff object
	 */

	@Override
	public Staff generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new Staff(headerList, list);
	}

}
