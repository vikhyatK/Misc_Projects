package com.mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;


import com.mvc.bean.Vets;
import com.mvc.dao.InsertDAO;

@SuppressWarnings("deprecation")
public class AddVetController extends SimpleFormController {

	public AddVetController() {
		setCommandClass(Vets.class);
		System.out.println("In AddVetController constr....");
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		Vets vet = (Vets) arg2;
		
		System.out.println("in method of AddVetController");
		InsertDAO dao_object=(InsertDAO)getApplicationContext().getBean("insertDao");
		int result = dao_object.insertVets(vet);
		
		if (result > 0 )
			mv.setViewName(getSuccessView());
		else
			mv.setViewName(getFormView());
		mv.addObject("value", "Vet");
		return mv;
	}
	
}
