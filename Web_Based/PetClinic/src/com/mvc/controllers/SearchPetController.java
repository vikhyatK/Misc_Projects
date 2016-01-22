package com.mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.mvc.bean.Pets;
import com.mvc.dao.SelectDAO;

@SuppressWarnings("deprecation")
public class SearchPetController  extends SimpleFormController
{

	public SearchPetController() {
		setCommandClass(Pets.class);
		System.out.println("In SearchPetController constr....");
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception 
	{
		
		System.out.println("in method of SearchPetController");
		ModelAndView mv=new ModelAndView();
		Pets pet_object= (Pets) command;

		SelectDAO dao_object = (SelectDAO)getApplicationContext().getBean("selectDao");
		pet_object=dao_object.selectPetDetails(pet_object.getPet_id());
			
			if (pet_object != null)
			{
				mv.setViewName(getSuccessView());
			}
			else
			{
				System.out.println("pet object is: "+pet_object);
				mv.setViewName(getFormView());
			}
				mv.addObject("pet_details", pet_object);
		return mv;
	  }
	}

