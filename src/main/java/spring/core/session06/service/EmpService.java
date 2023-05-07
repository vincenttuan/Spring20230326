package spring.core.session06.service;

import java.util.List;
import java.util.Optional;

import spring.core.session06.jdbc.entity.Emp;

public interface EmpService {
	public List<Emp> findAllEmps();
	// ...
	public Integer getMaxOfAge(); // 取得員工的最大年齡
}
