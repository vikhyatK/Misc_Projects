package com.mvcapp.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mvcapp.model.User;

public class UserValidator implements Validator{

	public boolean supports(Class candidate) {
		return User.class.isAssignableFrom(candidate);
		}

	public void validate(Object model, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required", "Field is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required", "Field is required.");
		
	}
	
	

}
