package action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import pojo.Vacancy;

import com.opensymphony.xwork2.ActionSupport;

import dao.VacancyDao;

public class ViewVacancyStruts extends ActionSupport implements SessionAware
{

	private Vacancy user=new Vacancy();
	
	private VacancyDao dao=null;
	
	private List<Vacancy> list;
	
	private Map map;
	
	
	@Override
	public String execute() throws Exception 
	{
		dao=new VacancyDao();
		int eid=Integer.parseInt(((String)map.get("eid")));
		System.out.println("map is "+eid);
		list=dao.getAllVacancies(eid);
		System.out.println("list is "+list.toString());
		
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
