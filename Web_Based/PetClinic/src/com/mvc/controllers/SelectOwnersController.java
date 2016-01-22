package com.mvc.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.mvc.bean.Owners;
import com.mvc.dao.SelectDAO;



public class SelectOwnersController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		System.out.println("in method of SelectOwnersController");
		ModelAndView mv = new ModelAndView();
		ArrayList<Owners> result = new ArrayList<Owners>();
		
		SelectDAO dao_object = (SelectDAO)getApplicationContext().getBean("selectDao");
			result = dao_object.selectOwners();
			if(result != null)
			{
				mv.setViewName("register_pets");
				mv.addObject("owner",result);
			}
			else 
			{
				mv.setViewName("home_admin");
			}
		return mv;
	}
}
