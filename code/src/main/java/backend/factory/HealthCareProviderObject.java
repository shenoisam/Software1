package backend.factory;

import java.util.List;

import backend.classes.HealthCareProvider;

public class HealthCareProviderObject implements FactoryObjects<HealthCareProvider> {

	@Override
	public HealthCareProvider generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new HealthCareProvider(headerList, list);
	}

}
