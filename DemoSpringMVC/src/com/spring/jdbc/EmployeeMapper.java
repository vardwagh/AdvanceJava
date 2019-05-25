package com.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee>{

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	      Employee employee = new Employee();
	      employee.setEmp_id(rs.getInt("emp_id"));
	      employee.setName(rs.getString("name"));
	      employee.setDept(rs.getString("dept"));
	      employee.setSal(rs.getInt("sal"));
	     //employee.setJoiningDate(rs.getDate("joiningDate"));
	      
	      
	      return employee;
	   }
}
