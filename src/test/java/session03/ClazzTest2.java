package session03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.core.session03.bean.Clazz;
import spring.core.session03.bean.Student;
import spring.core.session03.bean.Teacher;
import spring.core.session03.java_conf.AppConfig;

public class ClazzTest2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		Clazz clazz1 = ctx.getBean("clazz1", Clazz.class);
		System.out.println(clazz1);
		Clazz clazz2 = ctx.getBean("clazz2", Clazz.class);
		System.out.println(clazz2);
		Clazz clazz3 = ctx.getBean("clazz3", Clazz.class);
		System.out.println(clazz3);
		
	}

}
