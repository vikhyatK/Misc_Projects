package com.mvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mvc.bean.Owners;
import com.mvc.bean.Pets;
import com.mvc.bean.Vets;
import com.mvc.bean.Visit;


public class InsertDAO extends HibernateDaoSupport
{
	SessionFactory factory;
	
	public InsertDAO()
	{
		System.out.println("In Insert DAO constr...");
		//factory=getHibernateTemplate().getSessionFactory();
	}
	 
	public int insertOwner(Owners owner )
	{
		System.out.println("In insertOwner dao method.. ");
		int count=0;
		//Session sess=factory.openSession();
		Session sess=getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx=null;
		try{
			tx=sess.beginTransaction();
			sess.save(owner);
			tx.commit();
			count=1;
		}
		catch (Exception e) {
			System.out.println("err in Insert Owner DAO " + e);
			if (tx != null)
				tx.rollback();
			//throw e;
		}
		finally
		{
			if (sess != null)
				sess.close();
		}
		
		//Another Way of Doing Above Thing -- Just a 2-line code
		
		/*getHibernateTemplate().save(owner);
		count=1;*/
	    	
		return count;
	}     
	 
	 public int insertVets(Vets vet )
	 {
		 
		 System.out.println("In insertVets dao method.. ");
		 int count=0;
		 Session sess=getHibernateTemplate().getSessionFactory().openSession();
		 Transaction tx=null;
		 try
		 {
			 tx=sess.beginTransaction();
			 sess.save(vet);
			 tx.commit();
			 count=1;
		 }
		 catch (Exception e) 
		 {
			 System.out.println("err in Insert Vets DAO " + e);
			 if (tx != null)
				 tx.rollback();
			 	//throw e;
		 }
		 finally
		 {
			 if (sess != null)
				 sess.close();
		 }
		 return count;
		 
	 } 
	 public int insertPets(Pets pet )
	 {
		 System.out.println("In insertPets dao method.. ");
		 int count=0;
		 Session sess=getHibernateTemplate().getSessionFactory().openSession();
		 Transaction tx=null;
		 try
		 {
			 tx=sess.beginTransaction();
			 sess.save(pet);
			 tx.commit();
			 count=1;
		 }
		 catch (Exception e) 
		 {
			 System.out.println("err in Insert Pets DAO " + e);
			 if (tx != null)
				 tx.rollback();
			 	//throw e;
		 }
		 finally
		 {
			 if (sess != null)
				 sess.close();
		 }
		 return count; 
	 }
	 
	 public int insertVisits(Visit visit )
	 {
		 System.out.println("In insertVisits dao method.. ");
		 int count=0;
		 Session sess=getHibernateTemplate().getSessionFactory().openSession();
		 Transaction tx=null;
		 try
		 {
			 tx=sess.beginTransaction();
			 sess.save(visit);
			 tx.commit();
			 count=1;
		 }
		 catch (Exception e) 
		 {
			 System.out.println("err in Insert Visit DAO " + e);
			 if (tx != null)
				 tx.rollback();
			 	//throw e;
		 }
		 finally
		 {
			 if (sess != null)
				 sess.close();
		 }
		 return count;
	 }
}
