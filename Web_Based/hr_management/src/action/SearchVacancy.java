package action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import pojo.Vacancy;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.VacancyDao;

public class SearchVacancy extends ActionSupport implements ModelDriven<Vacancy>,SessionAware
{
	private long vid;
	private VacancyDao dao;
	private Vacancy vacancy=null;
	
	Map map;
	
	
	
	public long getVid() {
		return vid;
	}


	public void setVid(long vid) {
		this.vid = vid;
	}


	@Override
	public String execute() throws Exception 
	{
		dao=new VacancyDao();
		System.out.println("vid is "+getVid());
		vacancy =dao.viewSingleVacancyDetail(getVid());
		if(vacancy!=null)
		{
			map.put("vac", vacancy);
		return SUCCESS;
		}
		else
		{
			addFieldError("vid", "No Vacancy Found");
			return INPUT;
		}
	}


	@Override
	public void setSession(Map arg0)
	{		
		map=arg0;
	}


	@Override
	public Vacancy getModel() {
		// TODO Auto-generated method stub
		return vacancy;
	}
	
	
}
