package com.mvc.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.mvc.bean.Vets;
import com.mvc.dao.SelectDAO;

public class SelectVetController extends AbstractController
{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception
			{
		
		System.out.println("in method of SelectVetController");
		ModelAndView mv = new ModelAndView();
		HttpSession sess = request.getSession();
		ArrayList<Vets> result = new ArrayList<Vets>();
		System.out.println(request.getParameter("pet_Id"));
		SelectDAO dao_object = (SelectDAO)getApplicationContext().getBean("selectDao");
		result = dao_object.selectVets();
		
		if(result != null)
		{
			mv.setViewName("take_appointment");
			mv.addObject("vet",result);
			sess.setAttribute("pet_Id", request.getParameter("pet_Id"));
		}
		else {
			System.out.println("error");
		}
		return mv;
		
	}
	

}
