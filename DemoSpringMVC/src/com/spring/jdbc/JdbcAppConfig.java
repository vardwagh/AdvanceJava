package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JdbcAppConfig {
	
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/mysql");
        dataSource.setUsername("Mysqluser");
        dataSource.setPassword("Mysqluser");
		
		return dataSource;
		
	}
	
	@Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
	
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource());
		return namedParameterJdbcTemplate;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource());
		
		return transactionManager;
	}
	
	@Bean
    public EmployeeDao employeeDAO(){
        EmployeeDao empDao = new EmployeeDao();
     
        return empDao;
    }
}
