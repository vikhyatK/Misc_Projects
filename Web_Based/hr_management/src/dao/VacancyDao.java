package dao;

import java.math.BigDecimal;
import java.util.Date;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.xml.crypto.Data;

import org.hibernate.HibernateException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import pojo.Applicant;
import pojo.Applyvacancy;
import pojo.Employee;
import pojo.Vacancy;
import utils.HibernateUtils;

public class VacancyDao {
	public void create(Vacancy table) throws Exception
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
		
		//Query q=s.createQuery("from vacancy2 where eid:=?");
		
		s.save(table);
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
	
	public List<Vacancy> getAllVacancies(long eid)
	{
		Session s=null;
		Transaction tx=null;
		List<Vacancy> q=null;
		try
		{
		System.out.println("before get session");
		s=HibernateUtils.getSession();
		System.out.println("before transaction");
		tx=s.beginTransaction();
		System.out.println("savinn in table");
		
		 q=(List<Vacancy>)s.createQuery("from Vacancy where empid=:a").setParameter("a", eid).list();
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
	public String getAllVacancies()
	{
		Session s=null;
		Transaction tx=null;
		List<Vacancy> q=null;
		Vacancy vacancy=new Vacancy();
		long l=-1;
		try
		{
		System.out.println("before get session");
		s=HibernateUtils.getSession();
		System.out.println("before transaction");
		tx=s.beginTransaction();
		System.out.println("savinn in table");
		 q=(List<Vacancy>)s.createQuery("from Vacancy where status=:a").setParameter("a", "closed").list();
		 System.out.println("saved in table");
		 Object obj[]=(q).toArray();
			String optionselect="<option value='-1'>Select</option>";
			for(int i=0;i<obj.length;i++)
			{
				vacancy=(Vacancy)obj[i];
				long ids=vacancy.getVid();
				System.out.println("ids is: "+ids);
				if(l!=-1 && ids!=1)
				{
					System.out.println("if ");
					optionselect=optionselect + "<option value='"+vacancy.getVid()+"' selected=\"selected\">"+vacancy.getTitle()+"</option>"; 
				}
				else
				{
					System.out.println("else ");
					optionselect=optionselect +"<option value='" + vacancy.getVid()+ "'>" +(String)vacancy.getTitle()+ "</option>";
				}
			}
			
		 tx.commit();
		 return optionselect;
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
	
	public HashMap<Long,String> getAllVacancy()
	{
		Session s=null;
		Transaction tx=null;
		List<Vacancy> q=null;
		Vacancy vacancy=new Vacancy();
		long l=-1;
		try
		{
		System.out.println("before get session");
		s=HibernateUtils.getSession();
		System.out.println("before transaction");
		tx=s.beginTransaction();
		System.out.println("savinn in table");
		 q=(List<Vacancy>)s.createQuery("from Vacancy where status=:a").setParameter("a", "closed").list();
		 System.out.println("saved in table");
		 HashMap <Long, String> hm=new HashMap<>();
		 Object obj[]=(q).toArray();
			String optionselect="<option value='-1'>Select</option>";
			for(int i=0;i<obj.length;i++)
			{
				vacancy=(Vacancy)obj[i];
				long ids=vacancy.getVid();
				String title=vacancy.getTitle();
				hm.put(ids,title);
				
			}
			
		 tx.commit();
		 return hm;
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
	
	
	
	public List<Vacancy> getNonAppliedVacancies(long appid)
	{
		Session s=null;
		Transaction tx=null;
		List<Vacancy> q=null;
		try
		{
		System.out.println("before get session");
		s=HibernateUtils.getSession();
		System.out.println("before transaction");
		tx=s.beginTransaction();
		System.out.println("savinn in table");
		Applicant app=(Applicant) s.createQuery("from Applicant where appid=:a").setParameter("a", appid).uniqueResult();
		//System.out.println(app.getApplyvacancies());
		q=(List<Vacancy>)s.createQuery("from Vacancy where status=:a").setParameter("a", "open").list();
		System.out.println(q);
		List<Applyvacancy> apply=new ArrayList<>();
		try{
		apply=app.getApplyvacancies();
		 for (int i=0;i<=q.size()-1;i++) {
			 
			 Vacancy vacancy=q.get(i);
			 System.out.println("first");
			 if(apply!=null){
			 for (int j=0;j<=apply.size()-1;j++) {
				 //Applyvacancy applyvacancy=app.getApplyvacancies().get(i);
				 long vid=apply.get(j).getVacancy().getVid();
				 System.out.println("second and vis is "+vid);
				 System.out.println("vacancy vid is"+vacancy.getVid());
				 if(vacancy.getVid()==vid)
				 {System.out.println("three");
					 q.remove(i);
					 System.out.println("four");
				 }
			 }
			 }
		 }
		}
		 catch(Exception e){
			 
		 }
		 
		 System.out.println("saved in table");
		 System.out.println();
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
	
	public void update(Vacancy table)
	{
		Session s=null;
		Transaction tx=null;
		//table.setEmpid(eid);
		//table.setDeptid(did);
		try
		{
		System.out.println("before get session");
		s=HibernateUtils.getSession();
		System.out.println("before transaction");
		tx=s.beginTransaction();
		System.out.println("updating in table");
		s.update(table);
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
	public Vacancy viewVacancyDetail(long vid)
	{
		Session s=null;
		Transaction tx=null;
		Vacancy v=null;
		try
		{
			s=HibernateUtils.getSession();
			tx=s.beginTransaction();
			v=(Vacancy)s.createQuery("from Vacancy where vid=:a").setParameter("a", vid).uniqueResult();
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
		return v;
	}
	
	public Vacancy viewSingleVacancyDetail(long vid)
	{
		Session s=null;
		Transaction tx=null;
		Vacancy v=null;
		try
		{
			s=HibernateUtils.getSession();
			tx=s.beginTransaction();
			System.out.println("Vid is "+vid);
			v=(Vacancy)s.createQuery("from Vacancy where vid=:a").setParameter("a", vid).uniqueResult();
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
		return v;
	}
	
}
