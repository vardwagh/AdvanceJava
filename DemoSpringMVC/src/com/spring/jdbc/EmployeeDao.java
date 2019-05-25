package com.spring.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Repository
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate template;

	@Autowired
	private PlatformTransactionManager transactionManager;

	public int saveEmployee(Employee e) {
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		int count = 0;
		try {
			String query = "insert into emp values(" + e.getEmp_id() + ",'" + e.getName() + "','" + e.getDept() + "',"
					+ e.getSal() + ")";

			count = jdbcTemplate.update(query);
			//int a = 1/0;
			transactionManager.commit(status);

		} catch (Exception exception) {
			System.out.println(exception);
			transactionManager.rollback(status);
		}
		return count;
	}

	public Employee getEmployee(int id) {
		String sql = "select * from emp where emp_id=" + id;
		Employee employee = jdbcTemplate.query(sql, new ResultSetExtractor<Employee>() {
			@Override
			public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
				Employee e =null;
				while (rs.next()) {
					e = new Employee();
					e.setEmp_id(rs.getInt(1));
					e.setName(rs.getString(2));
					e.setDept(rs.getString(3));
					e.setSal(rs.getInt(4));
					
				}
				return e;
			}
		});
		return employee;
	}

	public int updateEmployee(Employee e) {
		String query = "update emp set name='" + e.getName() + "',dept='" + e.getDept() + "',sal='" + e.getSal() + "' where emp_id='"
				+ e.getEmp_id() + "' ";
		return jdbcTemplate.update(query);
	}

	public int deleteEmployee(Employee e) {
		String query = "delete from emp where emp_id='" + e.getEmp_id() + "' ";
		return jdbcTemplate.update(query);
	}

	public List<Employee> listEmployee() {
		String sql = "select * from emp";
		List<Employee> emList = jdbcTemplate.query(sql, new EmployeeMapper());
		return emList;
	}

	public void save(Employee e) {
		String query = "insert into emp values (:id,:name,:dept,:sal)";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", e.getEmp_id());
		map.put("name", e.getName());
		map.put("dept", e.getDept());
		map.put("sal", e.getSal());
	

		template.execute(query, map, new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				return ps.executeUpdate();
			}
		});
	}
}
