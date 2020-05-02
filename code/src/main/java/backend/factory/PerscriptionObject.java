package backend.factory;

import java.util.List;

import backend.classes.Perscription;

public class PerscriptionObject implements FactoryObjects<Perscription> {
	
	/**
	 * Defines a Perscription factory class
	 * 
	 * 
	 * @author katiewokoek
	 *
	 */
	
	/**
	 * creates a new instance of a Perscription object
	 * 
	 * @param headerList the list of header items
	 * @param list the list of object items
	 * 
	 * @return returns a new instance of a Perscription object
	 */

	@Override
	public Perscription generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new Perscription(headerList, list);
	}

}
