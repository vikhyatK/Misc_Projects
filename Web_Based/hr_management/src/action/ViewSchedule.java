package action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import pojo.Applyvacancy;

import com.opensymphony.xwork2.ActionSupport;

import dao.ApplyVacancyDao;

public class ViewSchedule extends ActionSupport implements SessionAware
{

	private Applyvacancy vacancy=new Applyvacancy();
	
	private ApplyVacancyDao dao=null;
	
	private List<Applyvacancy> list;
	
	private Map map;
	
	
	@Override
	public String execute() throws Exception 
	{
		dao=new ApplyVacancyDao();
		int eid=Integer.parseInt(((String)map.get("eid")));
		System.out.println("map is "+eid);
		list=dao.getSchedule(eid);
		System.out.println("list is "+list.toString());
		
		return SUCCESS;
		
	}
	
	public List<Applyvacancy> getList()
	{
		return list;
	}
	
	@Override
	public void setSession(Map arg0) 
	{
		
		map=arg0;
	}
	
}
