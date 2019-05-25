package com.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DepartmentMapper implements RowMapper<Department> {

	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		Department dept = new Department();
		dept.setId(rs.getInt("id"));
		dept.setDept(rs.getString("dept"));
		dept.setEmpCount(rs.getInt("empCount"));

		return dept;
	}
}
