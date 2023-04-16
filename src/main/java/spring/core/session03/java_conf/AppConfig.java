package spring.core.session03.java_conf;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import spring.core.session03.bean.Clazz;
import spring.core.session03.bean.Student;

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
	
	// 學生 1 配置
	@Bean
	public Student student1() {
		Set<Clazz> clazzs = new HashSet<>();
		clazzs.add(clazz1());
        clazzs.add(clazz2());
        clazzs.add(clazz3());
        Student student = new Student();
        student.setId(1);
        student.setName("John");
        student.setClazzs(clazzs);
        return student;
	}
	
	// 學生 2 配置
	@Bean
    public Student student2() {
        Set<Clazz> clazzs = new HashSet<>();
        clazzs.add(clazz1());
        clazzs.add(clazz3());
        Student student = new Student(2, "Mary");
        student.setClazzs(clazzs);
        return student;
    }
	
	// 講師 1 配置
	
	// 集合 Set、List、Map 配置
	
	// 講師 2 配置
	
}
