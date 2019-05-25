package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class WelcomeController {

	
	//	@RequestMapping(value="/", method=RequestMethod.GET)
	@RequestMapping(method = RequestMethod.GET)
	public String getWelcomeMessage(Model model) {
		model.addAttribute("activeHome", "active");
		model.addAttribute("message", "Hello World from Spring 4.3 MVC");
		System.out.println("Called ... welcome method!");
		return "welcome" ;
	}
}
