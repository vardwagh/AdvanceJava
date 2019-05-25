package com.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.jdbc.AllEmployeeDoa;
import com.spring.jdbc.DepartmentDao;
import com.spring.jdbc.Employee;
import com.spring.jdbc.EmployeeDao;

@Controller
public class AllEmployeeController {
	
	@Autowired
	private AllEmployeeDoa allemployeeDao;
	
	@Autowired
	private DepartmentDao departmentDao;

	@RequestMapping("/allemployee")
	public String success(Model model) {
		model.addAttribute("activeAllEmp", "active");
		
		model.addAttribute("employeeListAdmin", allemployeeDao.listAdminEmployee());
		model.addAttribute("employeeListHr", allemployeeDao.listHrEmployee());
		model.addAttribute("employeeListQa", allemployeeDao.listQaEmployee());
		model.addAttribute("employeeListprod", allemployeeDao.listprodEmployee());

		return "allemployee";
	}

}
