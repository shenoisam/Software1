package backend.factory;

import java.util.List;

import backend.classes.Perscription;

public class PerscriptionObject implements FactoryObjects<Perscription> {

	@Override
	public Perscription generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new Perscription(headerList, list);
	}

}
