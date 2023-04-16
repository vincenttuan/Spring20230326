package session03;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session03.bean.DBConn;

public class DBConnTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config3.xml");
		
		DBConn dbConn = ctx.getBean("dbConn", DBConn.class);
		dbConn.create();
		dbConn.update();
		dbConn.delete();
		dbConn.query();
		
		ctx.close();
	}

}
