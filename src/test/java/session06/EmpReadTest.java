package session06;

import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.core.session06.jdbc.dao.EmpDao;
import spring.core.session06.jdbc.entity.Emp;

public class EmpReadTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean(EmpDao.class);
		System.out.println(empDao.queryAll());
		System.out.println(empDao.queryEmps());
		
		Optional<Emp> optEmp = empDao.getOne(1);
		if(optEmp.isPresent()) {
			Emp emp = optEmp.get();
			System.out.println(emp);
		} else {
			System.out.println("資料不存在");
		}
		
		System.out.println(empDao.count());
		
		// 請問所有員工的平均年齡是多少 ?
		List<Emp> emps = empDao.queryEmps();
		double avgOfAge1 = emps.stream().mapToInt(Emp::getAge).average().getAsDouble();
		System.out.println(avgOfAge1);
		
		double avgOfAge2 = emps.stream().mapToInt(Emp::getAge).summaryStatistics().getAverage();
		System.out.println(avgOfAge2);
		
		double avgOfAge3 = empDao.getAvgOfAge();
		System.out.println(avgOfAge3);
	}

}
