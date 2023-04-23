package spring.core.session03.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.core.session03.mvc.model.User;
import spring.core.session03.mvc.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public void append(User user) {
		System.out.println("1.呼叫 UserController append(User user)");
		userService.add(user);
	}
	
	public List<User> queryAll() {
		return userService.findAll();
	}
}
