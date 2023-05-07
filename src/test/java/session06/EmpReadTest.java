package session06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import spring.core.session06.jdbc.dao.EmpDao;

public class EmpReadTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean(EmpDao.class);
		System.out.println(empDao.queryAll());
		
	}

}
