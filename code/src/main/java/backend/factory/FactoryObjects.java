package backend.factory;

import java.util.List;

public interface FactoryObjects<T> {
	
	/**
	 * Defines an interface for factory interface
	 * 
	 * 
	 * @author katiewokoek
	 *
	 */
	
	/**
	 * creates a new instance of a template object
	 * 
	 * @param headerList the list of header items
	 * @param list the list of object items
	 * 
	 * @return returns a new instance of a template object
	 */
	public T generateObject(List<String> headerList, List<Object> list);
 
}
