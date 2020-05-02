package backend.factory;

import java.util.List;

import backend.classes.Notes;

public class NotesObject implements FactoryObjects<Notes> {
	
	/**
	 * Defines a Notes factory class
	 * 
	 * 
	 * @author katiewokoek
	 *
	 */
	
	/**
	 * creates a new instance of a Notes object
	 * 
	 * @param headerList the list of header items
	 * @param list the list of object items
	 * 
	 * @return returns a new instance of a Notes object
	 */

	@Override
	public Notes generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new Notes(headerList, list);
	}

}
