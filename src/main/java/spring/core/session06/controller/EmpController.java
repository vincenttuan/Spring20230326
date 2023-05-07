package spring.core.session06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.core.session06.jdbc.entity.Emp;
import spring.core.session06.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	public List<Emp> queryEmps() {
		return empService.findAllEmps();
	}
	
	public Integer getMaxOfAge() {
		return empService.getMaxOfAge();
	}
	
	
}
