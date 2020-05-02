package backend.factory;

import java.util.List;

import backend.classes.TestOrder;

public class TestOrderObject implements FactoryObjects<TestOrder> {
	
	/**
	 * Defines a TestOrder factory class
	 * 
	 * 
	 * @author katiewokoek
	 *
	 */
	
	/**
	 * creates a new instance of a TestOrder object
	 * 
	 * @param headerList the list of header items
	 * @param list the list of object items
	 * 
	 * @return returns a new instance of a TestOrder object
	 */

	@Override
	public TestOrder generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new TestOrder(headerList, list);
	}

}
