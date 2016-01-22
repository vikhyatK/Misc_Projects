package dao;



import java.util.Date;
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

public class ApplyVacancyDao 
{
	Session s=null;
	Transaction tx=null;
	
	public void create(Applyvacancy app)
	{
		
		try{
			System.out.println("before session");
			s=HibernateUtils.getSession();
			System.out.println("after session");
			tx=s.beginTransaction();
			System.out.println("savinn in table");
			GregorianCalendar gc=new GregorianCalendar();
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
	
	public List<Applyvacancy> getSchedule(long eid)
	{
		GregorianCalendar gc=new GregorianCalendar();
		Session s=null;
		Transaction tx=null;
		List<Applyvacancy> q=null;
		try
		{
		System.out.println("before get session");
		s=HibernateUtils.getSession();
		System.out.println("before transaction");
		tx=s.beginTransaction();
		System.out.println("savinn in table");
		
		 q=(List<Applyvacancy>)s.createQuery("from Applyvacancy where irid=:a and scheduledate >=:b order by scheduledate").setParameter("a", eid).setParameter("b", gc.getTime()).list();
		 System.out.println("saved in table");
		 tx.commit();
		
		
		}
		catch (HibernateException e) 
		{
			if (tx != null)
				tx.rollback();
			throw e;
		} 
		finally 
		{
			if (s != null)
				s.close();
		}
		return q;
	}
	
	
	public List<Applyvacancy> getIwApplicant(long eid,Date iwdate)
	{
		//GregorianCalendar gc=new GregorianCalendar();
		Session s=null;
		Transaction tx=null;
		List<Applyvacancy> q=null;
		try
		{
		System.out.println("before get session");
		s=HibernateUtils.getSession();
		System.out.println("before transaction");
		tx=s.beginTransaction();
		System.out.println("savinn in table");
		
		 q=(List<Applyvacancy>)s.createQuery("from Applyvacancy where irid=:a and scheduledate =:b order by scheduledate").setParameter("a", eid).setParameter("b", iwdate).list();
		
		 for (int i=0;i<=q.size()-1;i++) {
			 Applyvacancy applyvacancy=q.get(i);
			 if(applyvacancy.getApplicant().getStatus().equals("selected") || applyvacancy.getApplicant().getStatus().equals("rejected"))
			{
				q.remove(i);
			}
				
		}
		 System.out.println("saved in table");
		 tx.commit();
		
		
		}
		catch (HibernateException e) 
		{
			if (tx != null)
				tx.rollback();
			throw e;
		} 
		finally 
		{
			if (s != null)
				s.close();
		}
		return q;
	}
	
	
	public String fetchIr()
	{
		long l=-1;
		Login log=new Login();
		Employee emp;
		List list=null;
		try
		{
			s=HibernateUtils.getSession();
			tx=s.beginTransaction();
			String hql="from Login where role=:iw order by userid";
			Query qry=s.createQuery(hql).setParameter("iw","iw");
			list=qry.list();
			Object obj[]=(list).toArray();
			String optionselect="<option value='-1'>Select</option>";
			for(int i=0;i<obj.length;i++)
			{
				log=(Login)obj[i];
				emp=log.getEmployee();
				long ids=log.getUserid();
				//System.out.println("ids is: "+ids);
				if(l!=-1 && ids==1)
				{
					optionselect=optionselect + "<option value='"+log.getUserid()+"' selected=\"selected\">"+emp.getFname()+" "+emp.getLname()+"</option>"; 
				}
				else
				{
					optionselect=optionselect +"<option value='" +log.getUserid()+ "'>" +emp.getFname()+" "+emp.getLname()+ "</option>";
				}
			}
			tx.commit();
			//System.out.println("Option select is "+optionselect);
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
	
	
	public String fetchApp(long vid)
	{
		long l=-1;
		Applicant app;
		List list=null;
		try
		{
			s=HibernateUtils.getSession();
			tx=s.beginTransaction();
			String hql="from Applyvacancy where vid=:v";
			Query qry=s.createQuery(hql).setParameter("v",vid);
			list=qry.list();
			Object obj[]=(list).toArray();
			String optionselect="<option value='-1'>Select</option>";
			for(int i=0;i<obj.length;i++)
			{
				app=((Applyvacancy)obj[i]).getApplicant();
				long ids=app.getAppid();
				System.out.println("ids is: "+ids);
				if(l!=-1 && ids==1)
				{
					optionselect=optionselect + "<option value='"+app.getAppid()+"' selected=\"selected\">"+app.getFname()+" "+app.getLname()+"</option>"; 
				}
				else
				{
					optionselect=optionselect +"<option value='" +app.getAppid()+ "'>" +app.getFname()+" "+app.getLname()+ "</option>";
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
	
	public void SheduleVacancy(Applyvacancy appvac,long vid,long appid)
	{
		System.out.println("before emp update");
		System.out.println("vid is "+vid);
		System.out.println("appid is "+appid);
		System.out.println("appvacid is "+appvac.getApvacancyid());
		try
		{
			
		System.out.println("before get session");
		s=HibernateUtils.getSession();
		System.out.println("before transaction");
		tx=s.beginTransaction();
		Applyvacancy oldappvac=(Applyvacancy) s.createQuery("from Applyvacancy where vid=:a and appid=:b").setParameter("a",vid).setParameter("b",appid).uniqueResult();
		
		oldappvac.setScheduledate(appvac.getScheduledate());
		oldappvac.setEmployee2(appvac.getEmployee2());
		oldappvac.setEmployee1(appvac.getEmployee1());
		oldappvac.getApplicant().setStatus("in process");
		s.update(oldappvac);
		tx.commit();
		System.out.println("after update");
		}
		catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		finally 
		{
			if (s != null)
				s.close();
		}
	}	
	
	
	public void updateAppStatus(long appid,String status)
	{
		Session s=null;
		Transaction tx=null;
		Applicant app;
		System.out.println(status+appid);
		try
		{
		System.out.println("before get session");
		s=HibernateUtils.getSession();
		System.out.println("before transaction");
		tx=s.beginTransaction();
		System.out.println("savinn in table");
		
		 app=(Applicant)s.createQuery("from Applicant where appid=:a").setParameter("a", appid).uniqueResult();
		 System.out.println("saved in table");
		 app.setStatus(status);
		 s.update(app);
		 tx.commit();
		
		
		}
		catch (HibernateException e) 
		{
			if (tx != null)
				tx.rollback();
			throw e;
		} 
		finally 
		{
			if (s != null)
				s.close();
		}
	}
	
	
}
