package spring.core.session03.java_conf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.text.TabableView;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import spring.core.session03.bean.Clazz;
import spring.core.session03.bean.DBConn;
import spring.core.session03.bean.Student;
import spring.core.session03.bean.Teacher;
import spring.core.session03.factory.CarFactory;

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
	@Bean
	public Teacher teacher1() {
		Set<Student> students = new HashSet<>();
		students.add(student1());
		students.add(student2());
		
		List<String> subjects = new ArrayList<>();
		subjects.add("Program");
		subjects.add("English");
		
		Map<String, Integer> salary = new HashMap<>();
		salary.put("base", 50000);
		salary.put("addition", 20000);
		
		Teacher teacher = new Teacher(1, "Bob");
		teacher.setStudents(students);
		teacher.setSubjects(subjects);
		teacher.setSalary(salary);
		return teacher;
		
	}
	
	// 集合 Set、List、Map 配置
	@Bean
	public Set<Student> students() {
		Set<Student> students = new HashSet<>();
		students.add(student1());
		students.add(student2());
		return students;
	}
	
	@Bean
	public List<String> subjects() {
		List<String> subjects = new ArrayList<>();
		subjects.add("Program");
		subjects.add("Music");
		subjects.add("English");
		subjects.add("Math");
		return subjects;
	}
	
	@Bean
	public Map<String, Integer> salary() {
		Map<String, Integer> salary = new HashMap<>();
		salary.put("base", 65000);
		salary.put("addition", 18000);
		return salary;
	}
	
	// 講師 2 配置
	@Bean
	public Teacher teacher2() {
		Teacher teacher = new Teacher(2, "Jean");
		teacher.setStudents(students());
		teacher.setSubjects(subjects());
		teacher.setSalary(salary());
		return teacher;
	}
	
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public DBConn dbConn() {
		return new DBConn();
	}
	
	@Bean
	@Scope("singleton")
	public CarFactory carFactory() {
		return new CarFactory();
	}
	
}
