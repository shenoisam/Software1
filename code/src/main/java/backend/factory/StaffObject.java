package backend.factory;

import java.util.List;

import backend.classes.Staff;

public class StaffObject implements FactoryObjects{

	@Override
	public Staff generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new Staff(headerList, list);
	}

}
