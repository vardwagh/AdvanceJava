package com.spring.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

@Repository
public class AllEmployeeDoa {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate template;

	@Autowired
	private PlatformTransactionManager transactionManager;
	
	public List<Employee> listAdminEmployee() {
		String sql = "select * from emp where dept='ADMIN'";
		List<Employee> emList = jdbcTemplate.query(sql, new EmployeeMapper());
		return emList;
	}
	
	public List<Employee> listHrEmployee() {
		String sql = "select * from emp where dept='HR'";
		List<Employee> emList = jdbcTemplate.query(sql, new EmployeeMapper());
		return emList;
	}
	public List<Employee> listQaEmployee() {
		String sql = "select * from emp where dept='QA'";
		List<Employee> emList = jdbcTemplate.query(sql, new EmployeeMapper());
		return emList;
	}
	
	public List<Employee> listprodEmployee() {
		String sql = "select * from emp where dept='PROD'";
		List<Employee> emList = jdbcTemplate.query(sql, new EmployeeMapper());
		return emList;
	}

}
