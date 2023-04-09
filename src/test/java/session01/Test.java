package session01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import spring.core.session01.bean.HelloBean;

public class Test {

	public static void main(String[] args) {
		// 傳統方式
		HelloBean helloBean = new HelloBean();
		helloBean.setName("Spring");
		System.out.println(helloBean.getName());
		System.out.println(helloBean);
		// 使用 Spring IOC 反轉控制技術
		// 1. 找到配置檔
		//ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/java/spring/core/bean/beans-config.xml");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");
		// 2. 取得物件
		HelloBean helloBean1 = (HelloBean)ctx.getBean("helloBean1");
		helloBean1.setName("Mary");
		System.out.println(helloBean1.getName());
		System.out.println(helloBean1);
		
		HelloBean helloBean1_1 = (HelloBean)ctx.getBean("helloBean1");
		System.out.println(helloBean1_1.getName());
		System.out.println(helloBean1_1);
		
		// 使用此方法,必須於配置檔中針對 HelloBean 只有一個設定
		//HelloBean helloBean1_2 = ctx.getBean(HelloBean.class);
		//System.out.println(helloBean1_2.getName());
		//System.out.println(helloBean1_2);
		
		HelloBean helloBean2 = (HelloBean)ctx.getBean("helloBean2");
		System.out.println(helloBean2.getName());
		
	}

}
