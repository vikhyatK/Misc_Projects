package com.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import sun.misc.Request;

import com.mvc.bean.Product;
import com.mvc.bean.User;
import com.mvc.connection.LoginDAO;
import com.mvc.connection.ProductDAO;



public class ViewAllOKProducts extends MultiActionController{
	/*home page*/
	public ModelAndView home_admin(HttpServletRequest arg0, HttpServletResponse arg1)throws Exception
	{
		return new ModelAndView("home_admin");		
	}
	
	/*View all ok products*/
	public ModelAndView view_all(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		ModelAndView mv=new ModelAndView();
		ArrayList<Product> result=new ArrayList<Product>(); 
		ProductDAO y=(ProductDAO) getApplicationContext().getBean("showall");
		result=(ArrayList<Product>) y.selectOKProduct();
		
		
	    String str=arg0.getParameter("cmd");
		System.out.println("string is "+str);
		mv.setViewName("view_all");
		
		mv.addObject("product",result);
		return mv;
	}
	
	/*View all damaged products*/
	public ModelAndView viewalldamaged(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		ModelAndView mv=new ModelAndView();
		System.out.println("in damaged");
		ArrayList<Product> result=new ArrayList<Product>(); 
		ProductDAO y=(ProductDAO) getApplicationContext().getBean("showall");
		result=(ArrayList<Product>) y.selectDamagedProduct();
		mv.setViewName("view_alld");
		mv.addObject("product",result);
		return mv;
	}
	/*View all update inventory products*/
	public ModelAndView updateinventory(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		ModelAndView mv=new ModelAndView();
		
		ArrayList<Product> result=new ArrayList<Product>(); 
		ProductDAO y=(ProductDAO) getApplicationContext().getBean("showall");
		result=(ArrayList<Product>) y.selectRequiredProduct();
		mv.setViewName("updateinventory");
		mv.addObject("productrequired",result);
		return mv;
	}
	/* View all  products */
	
	public ModelAndView update_p(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		ModelAndView mv=new ModelAndView();
		ArrayList<Product> result=new ArrayList<Product>(); 
		ProductDAO y=(ProductDAO) getApplicationContext().getBean("showall");
		result=(ArrayList<Product>) y.selectOKProduct();
		
		mv.setViewName("update_p");
		
		mv.addObject("product",result);
		return mv;
	}
	/*Order Placed Controller*/
	public ModelAndView ordernow(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		ModelAndView mv=new ModelAndView();
		
		ArrayList<Product> result=new ArrayList<Product>(); 
		ProductDAO y=(ProductDAO) getApplicationContext().getBean("showall");
		result=(ArrayList<Product>) y.placeOrder();
		mv.setViewName("orderSuccess");
		mv.addObject("productrecieved",result);
		return mv;
	}
	/*update price*/
	public ModelAndView change_price(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		ModelAndView mv = new ModelAndView();
		Product p = new Product();
		p.setId(Integer.parseInt(arg0.getParameter("id")));
		p.setName(arg0.getParameter("pname"));
		p.setPrice(Integer.parseInt(arg0.getParameter("price")));
		
		mv.setViewName("display_new_update_price");
		mv.addObject("product",p);
		return mv;
	}
	/*Update n save price controller*/
	public ModelAndView change_price1(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		ModelAndView mv=new ModelAndView();
		ArrayList<Product> result=new ArrayList<Product>(); 
		ProductDAO y=(ProductDAO) getApplicationContext().getBean("showall");
		int price=Integer.parseInt(arg0.getParameter("price"));
		int id=Integer.parseInt(arg0.getParameter("id"));
		String pname = arg0.getParameter("pname");
		System.out.println(id + pname + price); 
		Product p=new Product();
		p.setId(id);
		p.setName(pname);
		p.setPrice(price);
		result=(ArrayList<Product>) y.updatePrice(p);
		mv.setViewName("display_update_price");
		mv.addObject("product",result);
		return mv;
	}
}
	
	

	
	

