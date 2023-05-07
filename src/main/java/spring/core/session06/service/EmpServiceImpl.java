package spring.core.session06.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.core.session06.jdbc.dao.EmpDao;
import spring.core.session06.jdbc.entity.Emp;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpDao empDao;
	
	@Override
	public List<Emp> findAllEmps() {
		return empDao.queryEmps();
	}

	@Override
	public Integer getMaxOfAge() {
		List<Emp> emps = findAllEmps();
		return emps.stream().mapToInt(Emp::getAge).findAny().getAsInt();
	}

}
