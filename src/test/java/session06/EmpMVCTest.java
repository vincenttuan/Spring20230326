package session06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session06.controller.EmpController;
import spring.core.session06.jdbc.dao.EmpDao;
import spring.core.session06.jdbc.entity.Emp;

public class EmpMVCTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpController controller = ctx.getBean(EmpController.class);
		
		System.out.printf("%5s %10s %5s %30s\n", "eid", "ename", "age", "createtime");
		for(Emp emp : controller.queryEmps()) {
			System.out.printf("%5s %-10s %5s %30s\n", 
					emp.getEid(),
					emp.getEname(),
					emp.getAge(),
					emp.getCreatetime());
		}
		
		System.out.println("最大年齡: " + controller.getMaxOfAge());
		
	}

}
