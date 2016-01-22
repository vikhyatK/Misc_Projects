package action;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import pojo.Employee;
import pojo.Vacancy;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.VacancyDao;
public class EditVacancyAction extends ActionSupport implements ModelDriven<Vacancy>,SessionAware 
{


	private Vacancy user=new Vacancy();
	private VacancyDao dao;
	private Map map;
/*	private List<vacancy> vaca=null;*/

	@Override
	public String execute() throws Exception 
	{
		System.out.println("in execute");
		
		System.out.println(map.get("vid"));
		user.setVid( (long) map.get("vid"));
		dao=new VacancyDao();
		//BigDecimal  did=(BigDecimal)(map.get("did"));
		int eid=Integer.parseInt((String)map.get("eid"));
		Employee e=new Employee();
		e.setEmpid(eid);
		user.setEmployee(e);
		//e.setDeptid(did);
		Vacancy oldvac=(Vacancy) map.get("vac");
		user.setStatus(oldvac.getStatus());
		user.setOpeningdate(oldvac.getOpeningdate());
		dao.update(user);
		return SUCCESS;
	}
	@Override
	public void setSession(Map arg0)
	{
		map=arg0;
	}

	@Override
	public Vacancy getModel() 
	{
		return user;
	}
	
}
