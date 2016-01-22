/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mvc.controllers1;


import com.mvc.bean.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * 
 * @author SJ
 */
public class LoginCheckController extends SimpleFormController {

	public LoginCheckController() {
		  setCommandClass(User.class);
	        System.out.println("in ctor of LoginCheckController");

	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		ModelAndView mv=new ModelAndView();
	       User l1=(User)arg2;
	       System.out.println("in method of logincheckcontroller");
	       System.out.println(l1.getUserid());
	        if(l1.getUserid().equals("admin") && l1.getPassword().equals("admin"))
	            mv.setViewName(getSuccessView());
	        else
	            mv.setViewName(getFormView());
	          mv.addObject("user",l1.getUserid());
	        return mv;
	}

}
