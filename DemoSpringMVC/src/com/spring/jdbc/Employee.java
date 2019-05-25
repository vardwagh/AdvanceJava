package com.spring.jdbc;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {

	private int emp_id;
	@NotNull
	@Size(min = 1, max = 30,message="Number Only")
	private String name;
	@NotNull
	@Size(min = 2, max = 30)
	private String dept;
	@Min(1)
	private int sal;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joiningDate;
	private List<String> skills;

	public Employee() {
		super();
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", dept=" + dept + ", sal=" + sal + ", joiningDate="
				+ joiningDate + ", skills=" + skills + "]";
	}

}
