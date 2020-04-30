package backend.factory;

import java.util.List;

import backend.classes.TestResult;

public class TestResultObject implements FactoryObjects<TestResult> {

	@Override
	public TestResult generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new TestResult(headerList, list);
	}

}
