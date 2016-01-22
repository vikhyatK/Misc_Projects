/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mvc.controllers;


import com.mvc.bean.User;
import com.mvc.connection.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author SJ
 */
public class RegisterController extends SimpleFormController {

    public RegisterController() {
        setCommandClass(User.class);
 
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, BindException arg3) throws Exception {
        ModelAndView mv=new ModelAndView();
        User c1=(User)arg2;
        c1.setRole("user");
       int str = UserDAO.registerCustomer(c1);
        if(str>0)
            mv.setViewName(getSuccessView());
        else
            mv.setViewName(getFormView());
        return mv;
    }

   
 
  
    
}
