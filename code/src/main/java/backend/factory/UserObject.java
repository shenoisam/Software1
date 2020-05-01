package backend.factory;

import java.util.List;

import backend.classes.User;

public class UserObject implements FactoryObjects<User> {
	
	/**
	 * Defines a User factory class
	 * 
	 * 
	 * @author katiewokoek
	 *
	 */
	
	/**
	 * creates a new instance of a User object
	 * 
	 * @param headerList the list of header items
	 * @param list the list of object items
	 * 
	 * @return returns a new instance of a User object
	 */

	@Override
	public User generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new User(headerList, list);
	}

}
