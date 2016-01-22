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

import com.mvc.bean.Visit;
import com.mvc.dao.InsertDAO;


@SuppressWarnings("deprecation")
public class AddAppointmentController extends SimpleFormController{
 
	public AddAppointmentController() {
		setCommandClass(Visit.class);
		System.out.println("In AddAppointmentController constr....");
	}


	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception 
	{
		System.out.println("in method of AddAppointmentController");
		ModelAndView mv=new ModelAndView();
		Visit obj_visit=(Visit)command;
		/*if(obj_visit.getDate().compareTo(new Date()) < 0){
			mv.setViewName(getFormView());
			return
		}*/
		InsertDAO dao_object=(InsertDAO)getApplicationContext().getBean("insertDao");
		int result=dao_object.insertVisits(obj_visit);
		if (result > 0 )
			mv.setViewName(getSuccessView());
		else
		{
			System.out.println("In error else..");
			mv.setViewName(getFormView());
		}
		mv.addObject("value", "visit");
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
