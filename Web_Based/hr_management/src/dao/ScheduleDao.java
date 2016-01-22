package dao;

import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Applicant;
import pojo.Applyvacancy;
import pojo.Employee;
import pojo.Login;
import pojo.Vacancy;

import utils.HibernateUtils;

import action.ApplyVacancyAction;


public class ScheduleDao  
{
	Session s=null;
	Transaction tx=null;
	List list=null;
	public String fetchappid(long l,String status)
	{
		Applicant applicant =new Applicant();
		
		try
		{
			s=HibernateUtils.getSession();
			tx=s.beginTransaction();
			String hql="from Applicant order by appid where status=:a";
			Query qry=s.createQuery(hql).setParameter("a",status);
			list=qry.list();
			Object obj[]=(list).toArray();
			String optionselect="<option value='-1'>Select</option>";
			for(int i=0;i<obj.length;i++)
			{
				applicant=(Applicant)obj[i];
				long ids=applicant.getAppid();
				System.out.println("ids is: "+ids);
				if(l!=-1 && ids==1)
				{
					optionselect=optionselect + "<option value='"+applicant.getAppid()+"' selected=\"selected\">"+applicant.getFname()+"</option>"; 
				}
				else
				{
					optionselect=optionselect +"<option value='" + applicant.getAppid()+ "'>" +(String)applicant.getFname()+ "</option>";
				}
			}
			tx.commit();
			System.out.println("Option select is "+optionselect);
			return optionselect;
		}
		catch (HibernateException e)
		{
			if (tx != null)
				tx.rollback();
			throw e;
		} 
		finally {
			if (s != null)
				s.close();
		}
		
	}
	
	
	
	/*public String fetchHrempid(long l,String role)
	{
		Login log=new Login();
		
		try
		{
			s=HibernateUtils.getSession();
			tx=s.beginTransaction();
			String hql="from Login where role=:hr order by userid";
			Query qry=s.createQuery(hql).setParameter("hr",role);
			list=qry.list();
			System.out.println("list is "+list);
			Object obj[]=(list).toArray();
			String optionselect="<option value='-1'>Select</option>";
			for(int i=0;i<obj.length;i++)
			{
				log=(Login)obj[i];
				long ids=log.getUserid();
				System.out.println("ids is: "+ids);
				if(l!=-1 && ids==1)
				{
					optionselect=optionselect + "<option value='"+log.getUserid()+"' selected=\"selected\">"+log.getUserid()+"</option>"; 
				}
				else
				{
					optionselect=optionselect +"<option value='" +log.getUserid()+ "'>" +log.getUserid()+ "</option>";
				}
			}
			tx.commit();
			System.out.println("Option select is "+optionselect);
			return optionselect;
		}
		catch (HibernateException e)
		{
			if (tx != null)
				tx.rollback();
			throw e;
		} 
		finally {
			if (s != null)
				s.close();
		}
		
	}
	*/
	
	public String fetchIrempid(long l,String role)
	{
		Login log=new Login();
		
		try
		{
			s=HibernateUtils.getSession();
			tx=s.beginTransaction();
			String hql="from Login where role=:iw order by userid";
			Query qry=s.createQuery(hql).setParameter("iw",role);
			list=qry.list();
			Object obj[]=(list).toArray();
			String optionselect="<option value='-1'>Select</option>";
			for(int i=0;i<obj.length;i++)
			{
				log=(Login)obj[i];
				long ids=log.getUserid();
				System.out.println("ids is: "+ids);
				if(l!=-1 && ids==1)
				{
					optionselect=optionselect + "<option value='"+log.getUserid()+"' selected=\"selected\">"+log.getUserid()+"</option>"; 
				}
				else
				{
					optionselect=optionselect +"<option value='" +log.getUserid()+ "'>" +log.getUserid()+ "</option>";
				}
			}
			tx.commit();
			System.out.println("Option select is "+optionselect);
			return optionselect;
		}
		catch (HibernateException e)
		{
			if (tx != null)
				tx.rollback();
			throw e;
		} 
		finally {
			if (s != null)
				s.close();
		}
		
	}
	
	
	public void create(Applyvacancy app)
	{
		
		try{
			System.out.println("before session");
			s=HibernateUtils.getSession();
			System.out.println("after session");
			tx=s.beginTransaction();
			System.out.println("saving in table");
			
			System.out.println(app);
			s.save(app);
			tx.commit();
		}catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (s != null)
				s.close();
		}
	}

}
