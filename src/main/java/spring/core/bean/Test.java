package spring.core.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// 傳統方式
		HelloBean helloBean = new HelloBean();
		helloBean.setName("Spring");
		System.out.println(helloBean.getName());
		// 使用 Spring IOC 反轉控制技術
		// 1. 找到配置檔
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/java/spring/core/bean/beans-config.xml");
		HelloBean helloBean1 = (HelloBean)ctx.getBean("helloBean1");
		helloBean1.setName("Mary");
		System.out.println(helloBean1.getName());
		
		HelloBean helloBean1_1 = (HelloBean)ctx.getBean("helloBean1");
		System.out.println(helloBean1_1.getName());
	}

}
