package dao;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Applicant;
import pojo.Employee;
import pojo.Login;
import pojo.Vacancy;
import utils.HibernateUtils;
import org.hibernate.Query;

public class EmployeeDao
{

	Session s=null;
	Transaction tx=null;
	Employee employ;
	Login log;
	List<Long> id;
	public void createEmployee(Login login)
	{
		
		try
		{
			System.out.println("before get session");
			s=HibernateUtils.getSession();
			System.out.println("before transaction");
			tx=s.beginTransaction();
			System.out.println("savinn in table");
			s.save(login);
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
		
	public void edit(Employee emps)
	{
		System.out.println("before emp updates");
		try
		{
			
		System.out.println("before get sessions");
		s=HibernateUtils.getSession();
		System.out.println("before transactions");
		tx=s.beginTransaction();
		//Employee oldE=(Employee)s.createQuery("from Employee where empid=:a").setParameter("a",emps.getEmpid()).uniqueResult();
		//System.out.println("old emps"+oldE);
		
		System.out.println("updating in table");
		System.out.println(emps.toString());
		s.update(emps);
		System.out.println("after");
		tx.commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("in catch");
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
	
	public Employee getEmp(long Eid)
	{
		System.out.println("before emp update");
		try
		{
			System.out.println(Eid);
		System.out.println("before get session");
		s=HibernateUtils.getSession();
		System.out.println("before transaction");
		tx=s.beginTransaction();
		Employee emp=(Employee)s.createQuery("from Employee where empid=:a").setParameter("a",Eid).uniqueResult();
		System.out.println("updating in table");
		System.out.println(emp);
		tx.commit();
		return emp;
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
}
