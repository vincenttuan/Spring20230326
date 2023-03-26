package spring.core.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestCalc {

	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/java/spring/core/bean/beans-config.xml");
		//Calc calc = ctx.getBean(Calc.class);
		Calc calc = ctx.getBean("calc", Calc.class);
		calc.add(10, 20);
		
		System.out.println(calc.getResult());

	}

}
