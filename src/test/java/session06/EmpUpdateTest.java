package session06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.core.session06.jdbc.dao.EmpDao;

public class EmpUpdateTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean(EmpDao.class);
		// 修改測試
		int rowcount = empDao.update(1, "Tom", 17);
		System.out.println(rowcount);
		if(rowcount == 0) {
			System.out.println("修改失敗");
		} else {
			System.out.println("修改成功");
		}
	}

}
