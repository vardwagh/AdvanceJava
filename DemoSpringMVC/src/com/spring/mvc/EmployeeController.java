package com.spring.mvc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.jdbc.Department;
import com.spring.jdbc.DepartmentDao;
import com.spring.jdbc.Employee;
import com.spring.jdbc.EmployeeDao;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DepartmentDao departmentDao;

	@RequestMapping("/employee")
	public ModelAndView success(Model model) {
		model.addAttribute("activeEmp", "active");
		model.addAttribute("message", "You are logged in successfully!");
		model.addAttribute("employeeList", employeeDao.listEmployee());

		return new ModelAndView("employee", "employee", new Employee());
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute("employee") @Valid Employee employee,BindingResult bindingResult, Model model) {
		model.addAttribute("activeEmp", "active");
		if(bindingResult.hasErrors()){
			model.addAttribute("employeeList", employeeDao.listEmployee());
			return new ModelAndView("employee", "employee", employee);
		}
		Employee employee1 = employeeDao.getEmployee(employee.getEmp_id());
		System.out.println("Old record:"+employee1);
		if (employee1 == null) {
			System.out.println("New record:"+employee);
			employeeDao.save(employee);
		} else {
			employee1.setName(employee.getName());
			employee1.setDept(employee.getDept());
			employee1.setSal(employee.getSal());
			//employee1.setJoiningDate(employee.getJoiningDate());

			employeeDao.updateEmployee(employee1);
		}

		return new ModelAndView("redirect:/employee");
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable int id, Model model) {
		
		Employee employee = employeeDao.getEmployee(id);
		model.addAttribute("employeeList", employeeDao.listEmployee());
		System.out.println(employee);
		model.addAttribute("activeEmp", "active");
		return new ModelAndView("employee", "employee", employee);
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam int id, Model model) {
		Employee employee = new Employee();
		employee.setEmp_id(id);
		employeeDao.deleteEmployee(employee);
		return "redirect:/employee";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		
	}
	
	@ModelAttribute("skillsList")
	public Map<String,String> populateSkillList() {
		
		Map<String,String> javaSkill = new LinkedHashMap<String,String>();
		javaSkill.put("Hibernate", "Hibernate");
		javaSkill.put("Spring", "Spring");
		javaSkill.put("SpringBoot", "SpringBoot");
		javaSkill.put("Struts", "Struts");
		
		return javaSkill;
	}
	
	@ModelAttribute("depts")
	public Map<String,String> populateDeptSet(){
		Map<String,String> depts = new LinkedHashMap<String,String>();
		List<Department> list = departmentDao.listDept();
		
		for(Department dt : list){
			depts.put(dt.getDept(), dt.getDept());
		}
		
		return depts;
	}
}

