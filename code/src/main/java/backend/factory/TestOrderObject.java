package backend.factory;

import java.util.List;

import backend.classes.TestOrder;

public class TestOrderObject implements FactoryObjects<TestOrder> {

	@Override
	public TestOrder generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new TestOrder(headerList, list);
	}

}
