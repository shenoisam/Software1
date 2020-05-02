package backend.factory;

import java.util.List;

import backend.classes.TestResult;

public class TestResultObject implements FactoryObjects<TestResult> {
	
	/**
	 * Defines a TestResult factory class
	 * 
	 * 
	 * @author katiewokoek
	 *
	 */
	
	/**
	 * creates a new instance of a TestResult object
	 * 
	 * @param headerList the list of header items
	 * @param list the list of object items
	 * 
	 * @return returns a new instance of a TestResult object
	 */

	@Override
	public TestResult generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new TestResult(headerList, list);
	}

}
