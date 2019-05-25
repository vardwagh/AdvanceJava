package com.spring.jdbc;

public class Department {
	//create table dept(id int not null AUTO_INCREMENT,dept varchar(30), empCount int, primary key(id));
	
	private int id;
	private String dept;
	private int empCount;

	public Department() {
		super();
	}

	public Department(int id, String dept, int empCount) {
		super();
		this.id = id;
		this.dept = dept;
		this.empCount = empCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getEmpCount() {
		return empCount;
	}

	public void setEmpCount(int empCount) {
		this.empCount = empCount;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", dept=" + dept + ", empCount=" + empCount + "]";
	}

}
