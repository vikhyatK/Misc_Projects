package com.mvcapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvcapp.model.User;
import com.mvcapp.model.User.Frequency;
import com.mvcapp.validator.UserValidator;

@Controller
public class UserRegistrationController {
	
	@ModelAttribute("frequencies")
	public Frequency[] frequencies() {
		return Frequency.values();
	}
	

	@RequestMapping(value="register", method=RequestMethod.GET)
	public String loadFormPage(Model model) {
		model.addAttribute("subscriber", new User());
		return "formPage";
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String submitForm(@ModelAttribute("subscriber") User user, Model model, BindingResult result) {
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, result);
		if(result.hasErrors()){
			model.addAttribute("subscriber", user);
			return "formPage";
		}
		model.addAttribute("user", user);
		model.addAttribute("message", "Successfully registered!");
		return "welcome";
	}
}
