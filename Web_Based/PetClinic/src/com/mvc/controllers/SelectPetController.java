package com.mvc.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.mvc.bean.Pets;
import com.mvc.dao.SelectDAO;

@SuppressWarnings("deprecation")
public class SelectPetController extends SimpleFormController
{
	public SelectPetController() {
		setCommandClass(Pets.class);
		System.out.println("In SelectPetController constr....");
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception 
	{
		System.out.println("in method of SelectPetController");
		ModelAndView mv=new ModelAndView();
		Pets pet_object= (Pets) command;

		SelectDAO dao_object = (SelectDAO)getApplicationContext().getBean("selectDao");
		ArrayList<Pets> pets_list = dao_object.selectPetsDetails(pet_object.getOwner_id());
		
		if(pets_list.isEmpty())
		{
			mv.setViewName(getFormView());
		}
		else
			mv.setViewName(getSuccessView());
		mv.addObject("pet_details", pets_list);
		
		return mv;
	}
	
	
}
