package backend.factory;

import java.util.List;

import backend.classes.Test;

public class TestObject implements FactoryObjects<Test> {
	
	/**
	 * Defines a Test factory class
	 * 
	 * 
	 * @author katiewokoek
	 *
	 */
	
	/**
	 * creates a new instance of a Test object
	 * 
	 * @param headerList the list of header items
	 * @param list the list of object items
	 * 
	 * @return returns a new instance of a Test object
	 */

	@Override
	public Test generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new Test(headerList, list);
	}

}
