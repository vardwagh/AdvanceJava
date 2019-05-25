package com.spring.mvc;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.jdbc.Department;
import com.spring.jdbc.DepartmentDao;
import com.spring.jdbc.Employee;

@Controller
public class DeptController {

	@Autowired
	private DepartmentDao departmentDao; 
	
	@RequestMapping(value="/dept", method=RequestMethod.GET)
	public String dept(Model model){
		model.addAttribute("activeDept", "active");
		model.addAttribute("dept", new Department());
		model.addAttribute("deptList", departmentDao.listDept());
		
		return "department";
	}
	
	@RequestMapping(value="/dept", method = RequestMethod.POST)
	public ModelAndView addDept(@ModelAttribute("department") @Valid Department department,BindingResult bindingResult, Model model){
		
		model.addAttribute("activeDept", "active");
		if(bindingResult.hasErrors()){
			model.addAttribute("employeeList", departmentDao.listDept());
			return new ModelAndView("department", "dept", department);
		}
		Department department1 = departmentDao.getDepartment(department.getId());
		System.out.println("Old record:"+department1);
		if (department1 == null) {
			System.out.println("New record:"+department);
			departmentDao.save(department);
		} else {
			department1.setDept(department.getDept());
			department1.setEmpCount(department.getEmpCount());
			
			//employee1.setJoiningDate(employee.getJoiningDate());

			departmentDao.updateDepartment(department1);
		}

		return new ModelAndView("redirect:/dept");
		
		/*
		System.out.println("dept: "+department);
		departmentDao.save(department);
		model.addAttribute("dept", new Department());
		model.addAttribute("deptList", departmentDao.listDept());
		
		return new ModelAndView("department");*/
	}
	
	@RequestMapping("/deptedit/{id}")
	public ModelAndView edit(@PathVariable int id, Model model) {
		
		Department department = departmentDao.getDepartment(id);
		model.addAttribute("deptList", departmentDao.listDept());
		System.out.println(department);
		model.addAttribute("activeDept", "active");
		return new ModelAndView("department", "dept", department);
	}

	@RequestMapping("/deptdelete")
	public String delete(@RequestParam int id, Model model) {
		Department department = new Department();
		department.setId(id);
		departmentDao.deleteDepartment(department);
		return "redirect:/dept";
	}
}
