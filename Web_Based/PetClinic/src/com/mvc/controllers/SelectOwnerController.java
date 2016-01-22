package com.mvc.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.mvc.bean.Owners;
import com.mvc.dao.SelectDAO;

@SuppressWarnings("deprecation")
public class SelectOwnerController extends SimpleFormController
{
	public SelectOwnerController() {
		setCommandClass(Owners.class);
		System.out.println("In SelectOwnerController constr....");
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		
		System.out.println("in method of SelectOwnerController");
		ModelAndView mv=new ModelAndView();
		Owners own_object=(Owners)command;
		
		SelectDAO dao_object = (SelectDAO)getApplicationContext().getBean("selectDao");
		int ownerId=own_object.getOwn_id();
		ArrayList<Owners> result=new ArrayList<Owners>();
		
		result=dao_object.selectOwnerName(ownerId);
		if(result != null)
		{
			mv.setViewName(getSuccessView());
			mv.addObject("owner",result);
		}
		else 
		{
			mv.setViewName(getFormView());
		}
		return mv;
	}
	
}
