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
public class SearchOwnerController extends SimpleFormController {

	public SearchOwnerController() {
		setCommandClass(Owners.class);
		System.out.println("In SearchOwnerController constr....");
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		System.out.println("in method of SearchOwnerController");
		ModelAndView mv = new ModelAndView();
		Owners owner_object = (Owners) command;

		SelectDAO dao_object = (SelectDAO) getApplicationContext().getBean(
				"selectDao");
		String own_name = owner_object.getOwn_fname();

		System.out.println("In common : " + own_name);
		ArrayList<Owners> own_list = dao_object.selectOwnerNameById(own_name);
		if (own_list.isEmpty()) {
			mv.setViewName(getFormView());
		} else
			mv.setViewName(getSuccessView());
		mv.addObject("own_details", own_list);

		return mv;
	}

}
