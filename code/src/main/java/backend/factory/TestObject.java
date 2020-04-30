package backend.factory;

import java.util.List;

import backend.classes.Test;

public class TestObject implements FactoryObjects<Test> {

	@Override
	public Test generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new Test(headerList, list);
	}

}
