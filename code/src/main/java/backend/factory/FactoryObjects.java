package backend.factory;

import java.util.List;

public interface FactoryObjects<T> {
	
	public <T> T generateObject(List<String> headerList, List<Object> list);
}
