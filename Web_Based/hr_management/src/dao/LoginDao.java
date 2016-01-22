package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Employee;
import pojo.Login;
import utils.HibernateUtils;

public class LoginDao {
	public Login checklogin(long uid,String password)
	{
		Session s=null;
		Transaction tx=null;
		//Employee emp=null;
		Login login=null;
		try
		{
			System.out.println("before get session login");
			s=HibernateUtils.getSession();
			System.out.println("before transaction login");
			tx=s.beginTransaction();
			System.out.println(" in table");
			login=(Login)s.createQuery("from Login where userid=:p1 and password=:p2").setParameter("p1",uid).setParameter("p2", password).uniqueResult();
			//emp=(Employee)s.createQuery("from Employee where empid=:p1 and password=:p2").setParameter("p1",eid).setParameter("p2", password).uniqueResult();
			System.out.println("retrieved login");
			tx.commit();
			return login;
		}
		catch (HibernateException e) 
		{
			System.out.println("in catch");
			e.printStackTrace();
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
