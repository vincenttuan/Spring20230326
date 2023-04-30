package session05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.core.session05.aop_lab.AOPConfig;
import spring.core.session05.aop_lab.Dancer;
import spring.core.session05.aop_lab.Performance;

public class AOPLabTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);
		Performance dancer = ctx.getBean("dancer", Performance.class);
		
		dancer.perform(); // 執行表演
	}

}
