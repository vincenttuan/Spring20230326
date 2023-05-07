package spring.core.session06.jdbc.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import spring.core.session06.jdbc.entity.Emp;

public interface EmpDao {
	
	// 建立 CRUD - Create、Read、Update、Delete
	// 查詢多筆
	List<Map<String, Object>> queryAll(); // 多筆查詢(預設/通用型態)
	List<Emp> queryEmps(); // 多筆查詢(自訂型態)
	
	// 查詢單筆
	Optional<Emp> getOne(Integer eid); // 單筆查詢
	Integer count(); // 查詢資料筆數
	Double getAvgOfAge(); // 查詢員工平均年齡
	
	// 新增單筆
	int create(String ename, Integer age);
	
	// 新增多筆
	int[] batchCreate(List<Object[]> list);
	
	// 修改
	int update(Integer eid, String ename, Integer age);
	
	// 刪除
	int delete(Integer eid);
	
}
