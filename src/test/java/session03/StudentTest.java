package session03;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session03.bean.Student;

public class StudentTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config3.xml");
		List<Student> students = ctx.getBean("students", List.class);
		System.out.println(students);
		// 請印出每一個學生各修了多少學分 ?
		// 例如：
		// John: 6
		// Mary: 4
	}

}
