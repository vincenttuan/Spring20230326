package session01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.core.session01.bean.Hello;
import spring.core.session01.java_conf.JavaSpringConfig;

public class TestHello {

	public static void main(String[] args) throws Exception {
		// 利用 Java (JavaSpringConfig) 配置來取得 Bean 物件
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaSpringConfig.class);
		Hello hello = ctx.getBean("hello", Hello.class);
		System.out.println(hello);
		Thread.sleep(2000);
		Hello hello2 = ctx.getBean("hello", Hello.class);
		System.out.println(hello2);
	}

}
