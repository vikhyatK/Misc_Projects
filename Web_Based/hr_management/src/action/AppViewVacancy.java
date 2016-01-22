package action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import pojo.Vacancy;
import dao.VacancyDao;

public class AppViewVacancy extends ActionSupport implements SessionAware{

	private Vacancy vac=new Vacancy();
	private VacancyDao dao=null;
	
	private List<Vacancy> list;
	
	private Map map;
	
	@Override
	public String execute() throws Exception 
	{
		dao=new VacancyDao();
		System.out.println(map.get("eid"));
		long userid=Long.parseLong((String) map.get("eid"));
		//list=dao.getAllVacancies();
		list=dao.getNonAppliedVacancies(userid);
		System.out.println("list is "+list);
		return SUCCESS;
	}
	
	public List<Vacancy> getList()
	{
		return list;
	}
	
	@Override
	public void setSession(Map arg0) 
	{
		
		map=arg0;
	}
	

}
