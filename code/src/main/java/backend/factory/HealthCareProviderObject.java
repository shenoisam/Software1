package backend.factory;

import java.util.List;

import backend.classes.HealthCareProvider;

public class HealthCareProviderObject implements FactoryObjects<HealthCareProvider> {
	
	/**
	 * Defines a HealthCareProvider factory class
	 * 
	 * 
	 * @author katiewokoek
	 *
	 */
	
	/**
	 * creates a new instance of a HealthCareProvider object
	 * 
	 * @param headerList the list of header items
	 * @param list the list of object items
	 * 
	 * @return returns a new instance of a HealthCareProvider object
	 */

	@Override
	public HealthCareProvider generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new HealthCareProvider(headerList, list);
	}

}
