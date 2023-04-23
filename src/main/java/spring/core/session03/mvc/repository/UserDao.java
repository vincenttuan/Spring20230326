package spring.core.session03.mvc.repository;

import java.util.List;

import spring.core.session03.mvc.model.User;

public interface UserDao {
	void create(User user);
	List<User> readAll();
}
