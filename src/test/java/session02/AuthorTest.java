package session02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session02.bean.Author;

public class AuthorTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config2.xml");
		
		Author author1 = ctx.getBean("author1", Author.class);
		System.out.println("author1: " + author1); 
		// 要透過手動自行注入資料
		author1.setName("Bob");
		author1.setSex('男');
		author1.setAge(24);
		System.out.println("author1: " + author1); 
		
		Author author2 = ctx.getBean("author2", Author.class); // 資料已透過設定檔的方法注入配置
		System.out.println("author2: " + author2); 
		
		Author author3 = ctx.getBean("author3", Author.class); // 資料已透過設定檔的建構子注入配置
		System.out.println("author3: " + author3); 
		
		Author author4 = ctx.getBean("author4", Author.class); // 資料已透過 p 簡化方法注入配置
		System.out.println("author4: " + author4); 
		
		Author author5 = ctx.getBean("author5", Author.class); // 資料已透過 p 簡化建構子注入配置
		System.out.println("author5: " + author5); 
		
	}

}
