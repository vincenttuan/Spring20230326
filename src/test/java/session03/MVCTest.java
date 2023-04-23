package session03;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session03.mvc.controller.UserController;
import spring.core.session03.mvc.model.User;

public class MVCTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config3-mvc.xml");
		//User user = ctx.getBean("student", User.class);
		User user = ctx.getBean("user", User.class);
		System.out.println(user);
		System.out.println(user.getNickname().length);
		System.out.println(user.getSubjects().size());
		System.out.println(user.getScores().size());
		System.out.println(user.getHobbies().size());
		System.out.println("------------------------------------------------------------------");
		// 透過 UserController 新增 User
		UserController userController = ctx.getBean("userController", UserController.class);
		userController.append(user);
		userController.append(user);
		userController.append(user);
		// 查詢所有 users 的資料
		List<User> users = userController.queryAll();
		System.out.println(users);
		System.out.println("資料筆數: " + users.size());
	}

}
