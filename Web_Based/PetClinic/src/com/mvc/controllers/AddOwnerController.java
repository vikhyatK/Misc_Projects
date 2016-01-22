/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mvc.controllers;

import com.mvc.bean.Owners;
import com.mvc.dao.InsertDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * 
 * @author SJ
 */
@SuppressWarnings("deprecation")
public class AddOwnerController extends SimpleFormController {

	public AddOwnerController() {
		setCommandClass(Owners.class);
		System.out.println("In AddOwnerController constr....");
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		Owners owner = (Owners) arg2;

		System.out.println("in method of AddOwnerController");
		InsertDAO dao_object=(InsertDAO)getApplicationContext().getBean("insertDao");
		int result = dao_object.insertOwner(owner);
		
		if (result > 0 )
			mv.setViewName(getSuccessView());
		else
			mv.setViewName(getFormView());
		mv.addObject("value", "Owner");
		return mv;
	}
}
