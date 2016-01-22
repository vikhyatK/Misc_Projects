package com.mvc.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.mvc.bean.Pets;
import com.mvc.dao.InsertDAO;

@SuppressWarnings("deprecation")
public class AddPetsController extends SimpleFormController
{
	public AddPetsController() 
	{
		setCommandClass(Pets.class);
		System.out.println("In AddPetsController constr....");
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception 
	{
		System.out.println("in method of AddPetsController");
		ModelAndView mv=new ModelAndView();
		Pets obj_pet=(Pets)command;
		
		InsertDAO dao_object=(InsertDAO)getApplicationContext().getBean("insertDao");
		int result=dao_object.insertPets(obj_pet);
		if (result > 0 )
			mv.setViewName(getSuccessView());
		else
		{
			mv.setViewName(getFormView());
		}
		mv.addObject("value", "Pets");
		return mv;
	}

	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");    
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);     
		binder.registerCustomEditor(Date.class, editor); 
	}
	
	
}
