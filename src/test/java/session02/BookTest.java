package session02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session02.bean.Author;
import spring.core.session02.bean.Book;

public class BookTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config2.xml");
		Author author1 = ctx.getBean("author1", Author.class);
		// 要透過手動自行注入資料
		author1.setName("Bob");
		author1.setSex('男');
		author1.setAge(24);
		
		Book book1 = ctx.getBean("book1", Book.class);
		// 要透過手動自行注入資料
		book1.setName("Java");
		book1.setPrice(500);
		book1.setAuthor(author1);
		System.out.println("book1: " + book1);
	}

}
