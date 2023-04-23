package spring.core.session03.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.core.session03.mvc.model.User;
import spring.core.session03.mvc.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void add(User user) {
		System.out.println("2.呼叫 UserService add(User user)");
		userDao.create(user);
	}

	@Override
	public List<User> findAll() {
		return userDao.readAll();
	}

}
