package spring.core.session03.mvc.repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import spring.core.session03.mvc.model.User;

public class UserDaoImpl implements UserDao {
	
	private static List<User> users = new CopyOnWriteArrayList<>();
	
	@Override
	public void create(User user) {
		users.add(user);
	}

	@Override
	public List<User> readAll() {
		return users;
	}
	
}
