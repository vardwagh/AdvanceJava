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

@Repository
public class DepartmentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate template;

	public void save(Department e) {
		String query = "insert into dept values (:id,:name,:empCount)";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", e.getId());
		map.put("name", e.getDept());
		map.put("empCount", e.getEmpCount());
		

		template.execute(query, map, new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				return ps.executeUpdate();
			}
		});
	}
	
	
	public Department getDepartment(int id) {
		String sql = "select * from dept where id=" + id;
		Department dept = jdbcTemplate.query(sql, new ResultSetExtractor<Department>() {
			@Override
			public Department extractData(ResultSet rs) throws SQLException, DataAccessException {
				Department d =null;
				while (rs.next()) {
					d = new Department();
					d.setId(rs.getInt(1));
					d.setDept(rs.getString(2));
					d.setEmpCount(rs.getInt(3));
					
					
				}
				return d;
			}
		});
		return dept;
	}
	
	public int updateDepartment(Department d) {
		String query = "update dept set dept='" + d.getDept() + "',empCount='" + d.getEmpCount() + "' where id='"+ d.getId() + "' ";
		return jdbcTemplate.update(query);
	}
	
	public int deleteDepartment(Department d) {
		String query = "delete from dept where id='" + d.getId() + "' ";
		return jdbcTemplate.update(query);
	}
	
	public List<Department> listDept() {
		String sql = "select * from dept";
		List<Department> deptList = jdbcTemplate.query(sql, new DepartmentMapper());
		return deptList;
	}
}
