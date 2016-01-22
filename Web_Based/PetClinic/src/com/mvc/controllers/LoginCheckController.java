/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.mvc.bean.Login;
import com.mvc.dao.LoginDAO;

/**
 * 
 * @author SJ
 */
@SuppressWarnings("deprecation")
public class LoginCheckController extends SimpleFormController {

	public LoginCheckController() {
		System.out.println("In LoginCheckController constr....");
		setCommandClass(Login.class);
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		Login login_object = (Login) arg2;
		System.out.println("in method of logincheckcontroller");
		LoginDAO dao_object=(LoginDAO)getApplicationContext().getBean("loginDao");
		boolean result = dao_object.selectUser(login_object);
		if (result)
			mv.setViewName(getSuccessView());
		else
		{
			mv.setViewName(getFormView());
			mv.addObject("error","Username or Password is incorrect");
		}
			mv.addObject("user", login_object.getUsername());
			HttpSession sess = arg0.getSession();
			sess.setAttribute("username", login_object.getUsername());
		return mv;
	}
}
