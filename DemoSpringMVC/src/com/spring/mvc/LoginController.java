package com.spring.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Login;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String loginGet(Model model) {
		model.addAttribute("activeLogin", "active");
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView loginPost(HttpServletRequest request, HttpServletResponse response, Model model) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		model.addAttribute("activeLogin", "active");
		if (name == null || password == null) {
			return new ModelAndView("login", "message", "Sorry! Incorrect username or password.");
		}
		Login login = new Login();
		login.setName(name);
		login.setPassword(password);

		boolean status = login.validate();

		if (status) {
			return new ModelAndView("redirect:/employee");
		} else {
			return new ModelAndView("login", "message", "Sorry! Incorrect username or password.");
		}
	}
}
