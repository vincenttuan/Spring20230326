package session01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import spring.core.session01.bean.Calc;

public class TestCalc {

	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/java/spring/core/bean/beans-config.xml");
		//Calc calc = ctx.getBean(Calc.class);
		Calc calc = ctx.getBean("calc", Calc.class);
		calc.add(10, 20);
		System.out.println(calc.getResult()); // 30
		
		Calc calc2 = ctx.getBean("calc", Calc.class);
		calc2.add(30, 40);
		System.out.println(calc2.getResult()); // 70
		
		
		System.out.println(calc.getResult()); // ??
	}

}
