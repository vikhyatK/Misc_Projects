/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mvc.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import com.mvc.bean.User;
import com.mvc.connection.LoginDAO;

/**
 *
 * @author SJ
 */
@SuppressWarnings("deprecation")
public class LoginCheckController extends SimpleFormController {

	public LoginCheckController() {
        setCommandClass(User.class);
        System.out.println("in ctor of LoginCheckController");
  
    }
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		
		//return super.onSubmit(request, response, command, errors);
		ModelAndView mv=new ModelAndView();
		User l=(User)command;
		System.out.println("l"+l);
		LoginDAO y=(LoginDAO) getApplicationContext().getBean("loginDao");
		boolean b=y.isValid(l);
		
		mv.addObject("user", l.getUserid());
		if(b==true)
			mv.setViewName(getSuccessView());
		else 
			mv.setViewName(getFormView());	
	    return mv;
	}
   /* @Override
    protected ModelAndView onSubmit(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, BindException arg3) throws Exception {
    	ModelAndView mv=new ModelAndView();
        User l1=(User)arg2;
        System.out.println(arg0.getParameter("cmd"));
        arg0.getSession().setAttribute("userid", l1.getUserid());
        User c = LoginDAO.validateUser(l1.getUserid());
        if(l1.getUserid().equals(c.getUserid()) && l1.getPassword().equals(c.getPassword())&&c.getRole().equals("admin"))
            mv.setViewName(getSuccessView());
        else
            mv.setViewName(getFormView());
          	mv.addObject("user",l1.getUserid());
          
        return mv;
    	
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
    }*/

   
 
  
    
}
