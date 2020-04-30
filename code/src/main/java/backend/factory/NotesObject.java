package backend.factory;

import java.util.List;

import backend.classes.Notes;

public class NotesObject implements FactoryObjects<Notes> {

	@Override
	public Notes generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new Notes(headerList, list);
	}

}
