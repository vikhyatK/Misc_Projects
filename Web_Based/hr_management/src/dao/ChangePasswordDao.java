package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Login;
import utils.HibernateUtils;
import org.hibernate.Query;

public class ChangePasswordDao
{
	
	Session s=null;
	Transaction tx=null;
	Login log=new Login();
	public String changeOldPass(long uid, String pass,String newPass)
	{
		System.out.println("In dao chek old pass");
		try
		{
			s=HibernateUtils.getSession();
			tx=s.beginTransaction();
			log=(Login)s.createQuery("from Login where userid=:a and password=:b").setParameter("a",uid).setParameter("b",pass).uniqueResult(); 
			 if(log !=null)
			 {
				 log.setPassword(newPass);
				 s.update(log);
				 tx.commit();
				 return log.getRole();
			 }
			 else{
				return null;
			 }
				 
				 
			 
			
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
