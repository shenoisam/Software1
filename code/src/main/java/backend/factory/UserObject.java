package backend.factory;

import java.util.List;

import backend.classes.User;

public class UserObject implements FactoryObjects<User> {

	@Override
	public User generateObject(List<String> headerList, List<Object> list) {
		// TODO Auto-generated method stub
		return new User(headerList, list);
	}

}
