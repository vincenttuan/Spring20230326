package session06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.core.session06.jdbc.dao.EmpDao;

public class EmpDeleteTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean(EmpDao.class);
		// 刪除測試
		int rowcount = empDao.delete(2);
		System.out.println(rowcount);
		if(rowcount == 0) {
			System.out.println("刪除失敗");
		} else {
			System.out.println("刪除成功");
		}
	}

}
