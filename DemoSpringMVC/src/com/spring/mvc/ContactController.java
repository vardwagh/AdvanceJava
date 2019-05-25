package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {

	@RequestMapping("/contact")
	public String dept(Model model){
		model.addAttribute("activeContact", "active");
		
		return "contact";
	}
}
