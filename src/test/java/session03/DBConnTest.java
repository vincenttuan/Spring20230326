package session03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session03.bean.DBConn;
import spring.core.session03.java_conf.AppConfig;

public class DBConnTest {

	public static void main(String[] args) {
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config3.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		DBConn dbConn = ctx.getBean("dbConn", DBConn.class);
		dbConn.create();
		dbConn.update();
		dbConn.delete();
		dbConn.query();
		
		ctx.close();
	}

}
