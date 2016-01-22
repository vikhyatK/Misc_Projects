package com.mvc.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mvc.bean.Login;


public class LoginDAO extends HibernateDaoSupport
{
	public LoginDAO()
	{
		System.out.println("In Login DAO constr...");
	}
	
	@SuppressWarnings("rawtypes")
	public  boolean selectUser(Login user)
    {
    
		System.out.println("In selectUser dao method.. ");
		String name= user.getUsername();
		
		List obj_list=getHibernateTemplate().find("FROM Login l where l.username = ?", name);
		Login obj_fromDb = (Login)obj_list.get(0);
		if(obj_fromDb.getPassword().equals(user.getPassword()))
		{
			return true;
		}
		else {
			return false;
		}
   }
}
