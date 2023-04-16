package session03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session03.bean.Car;
import spring.core.session03.java_conf.AppConfig;

public class CarFactoryTest {

	public static void main(String[] args) {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config3.xml");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		// 透過 carFactory 工廠來取得 Car 實體
		Car car1 = ctx.getBean("carFactory", Car.class);
		Car car2 = ctx.getBean("carFactory", Car.class);
		System.out.println(car1);
		System.out.println(car2);
	}

}
