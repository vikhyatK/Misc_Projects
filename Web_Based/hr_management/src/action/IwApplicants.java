package action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import pojo.Applyvacancy;

import com.opensymphony.xwork2.ActionSupport;

import dao.ApplyVacancyDao;

public class IwApplicants extends ActionSupport implements SessionAware
{

	private Date interviewDate;
	//private Applyvacancy vacancy=new Applyvacancy();
	private ApplyVacancyDao dao=null;
	private List<Applyvacancy> list;
	private Map map;
	
	
	@Override
	public String execute() throws Exception 
	{
		dao=new ApplyVacancyDao();
		int eid=Integer.parseInt(((String)map.get("eid")));
		System.out.println("map is "+eid);
		list=dao.getIwApplicant(eid,interviewDate);
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
	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}
}
