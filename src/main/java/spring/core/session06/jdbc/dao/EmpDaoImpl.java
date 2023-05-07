package spring.core.session06.jdbc.dao;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.core.session06.jdbc.entity.Emp;

@Repository
public class EmpDaoImpl implements EmpDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> queryAll() {
		String sql = "select eid, ename, age, createtime from emp";
		List<Map<String, Object>> emps = jdbcTemplate.queryForList(sql);
		return emps;
	}

	@Override
	public List<Emp> queryEmps() {
		String sql = "select eid, ename, age, createtime from emp";
		// BeanPropertyRowMapper: 自動將資料表的每一筆紀錄的每一個欄位都對應到 Java 物件(Ex: Emp)裡的欄位/屬性/物件變數
		List<Emp> emps = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
		return emps;
	}

	@Override
	public Optional<Emp> getOne(Integer eid) {
		String sql = "select eid, ename, age, createtime from emp where eid=?";
		Object[] args = {eid};
		Emp emp = null;
		try {
			emp = jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper<>(Emp.class));
		} catch (Exception e) {
			
		}
		Optional<Emp> optEmp = Optional.ofNullable(emp);
		return optEmp;
	}

	@Override
	public Integer count() {
		String sql = "select count(*) from emp";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}
	
	@Override
	public Double getAvgOfAge() {
		String sql = "select AVG(age) from emp";
		Double avgOfAge = jdbcTemplate.queryForObject(sql, Double.class);
		return avgOfAge;
	}
	
	@Override
	public int create(String ename, Integer age) {
		String sql = "Insert into emp(ename, age) values(?, ?)";
		//Object[] args = {ename, age};
		//int rowcount = jdbcTemplate.update(sql, args);
		int rowcount = 0;
		try {
			rowcount = jdbcTemplate.update(sql, ename, age);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rowcount;
	}

	@Override
	public int[] batchCreate(List<Object[]> list) {
		String sql = "Insert into emp(ename, age) values(?, ?)"; 
		int[] rowcounts = jdbcTemplate.batchUpdate(sql, list);
		return rowcounts;
	}

	@Override
	public int update(Integer eid, String ename, Integer age) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer eid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
