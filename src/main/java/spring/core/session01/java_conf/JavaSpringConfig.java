package spring.core.session01.java_conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring.core.session01.bean.Hello;

// 利用 Java 語法來配置 Bean 物件內容
// 取代傳統 .xml 的配置
@Configuration
public class JavaSpringConfig {
	
	@Bean(name = "hello")
	@Scope("singleton")
	public Hello getHello() {
		Hello hello = new Hello();
		return hello;
	}
}
