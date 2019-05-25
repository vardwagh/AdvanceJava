package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.CreditCard;

@Controller
public class CardRestController {

	@RequestMapping(value = "/credit-card/{card-no}", method = RequestMethod.GET)
	public String parseCreditCardNumber(@PathVariable("card-no") CreditCard creditCard, Model model) {
		model.addAttribute("creditCard", creditCard);
		return "welcome";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(CreditCard.class, new CreditCardEditor());
	}
}
