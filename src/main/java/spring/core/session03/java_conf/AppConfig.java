package spring.core.session03.java_conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import spring.core.session03.bean.Clazz;

@Configuration
@PropertySource("classpath:data.properties")
public class AppConfig {
	
	@Value("${clazz.name}")
	private String clazzName;
	
	@Value("${clazz.credit}")
	private Integer clazzCredit;
	
	@Bean
	public Clazz clazz1() {
		Clazz clazz = new Clazz();
		clazz.setId(1);
		clazz.setName(clazzName);
		clazz.setCredit(clazzCredit);
		return clazz;
	}
	
	@Bean
	public Clazz clazz2() {
		Clazz clazz = new Clazz();
		clazz.setId(2);
		clazz.setName("English");
		clazz.setCredit(2);
		return clazz;
	}
	
	@Bean
	public Clazz clazz3() {
		Clazz clazz = new Clazz();
		clazz.setId(3);
		clazz.setName("Math");
		clazz.setCredit(1);
		return clazz;
	}
	
	
	
}
