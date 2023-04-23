package spring.core.session03.mvc.service;

import java.util.List;

import spring.core.session03.mvc.model.User;

public interface UserService {
	void add(User user);
	List<User> findAll();
}
