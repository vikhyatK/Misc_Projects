package dao;

import java.util.GregorianCalendar;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Applicant;
import pojo.Login;
import pojo.Vacancy;
import utils.HibernateUtils;

public class ApplicantDao 
{

	public long create(Applicant table,Login lg) throws Exception
	{
		Session s=null;
		Transaction tx=null;
				
		try
		{
		System.out.println("before get session");
		s=HibernateUtils.getSession();
		System.out.println("before transaction");
		tx=s.beginTransaction();
		System.out.println("savinn in table");
		
		GregorianCalendar gc=new GregorianCalendar();
		table.setCurrentdate(gc.getTime());
		table.setStatus("Not In Process");
		System.out.println(table);
		lg.setApplicant(table);
		table.setLogin(lg);
		s.save(lg);
		tx.commit();
		return lg.getUserid();
		}
		catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (s != null)
				s.close();
		}
	}
	
	public void UpdateProfile(Applicant app) throws Exception
	{
		Session s=null;
		Transaction tx=null;
		try
		{
		System.out.println("before get session");
		s=HibernateUtils.getSession();
		System.out.println("before transaction");
		tx=s.beginTransaction();
		System.out.println("savinn in table");
		
		GregorianCalendar gc=new GregorianCalendar();
		app.setCurrentdate(gc.getTime());
		app.setStatus("Not In Process");
		System.out.println(app);
		
		s.update(app);
		tx.commit();
		}
		catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (s != null)
				s.close();
		}
		
	}
	
	
	public void edit(Applicant app) throws Exception
	{
		Session s=null;
		Transaction tx=null;
		try
		{
		System.out.println("before get session");
		s=HibernateUtils.getSession();
		System.out.println("before transaction");
		tx=s.beginTransaction();
		System.out.println("savinn in table");
		
		GregorianCalendar gc=new GregorianCalendar();
		app.setCurrentdate(gc.getTime());
		app.setStatus("Not In Process");
		System.out.println(app);
		
		s.save(app);
		tx.commit();
		}
		catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (s != null)
				s.close();
		}
		
	}
	
	
	public Applicant viewapplicant(long a)
	{
		Session s=null;
		Transaction tx=null;
		Applicant appli=null;
		try
		{
			System.out.println("before get session login");
			s=HibernateUtils.getSession();
			System.out.println("before transaction login");
			tx=s.beginTransaction();
			System.out.println(" in table");
			System.out.println("in dao before quary "+a);
			appli=(Applicant)s.createQuery("from Applicant where appid=:a").setParameter("a",a).uniqueResult();
			if(appli!=null)
				System.out.println("in view applicant doa layer"+appli.getAppid());
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
		if (appli!=null)
			return appli;
		else {return null;}
	}
}
