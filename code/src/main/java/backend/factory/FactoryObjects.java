package backend.factory;

import java.util.List;

public interface FactoryObjects {
	public Object generateObject(List<String> headerList, List<Object> list);
}
