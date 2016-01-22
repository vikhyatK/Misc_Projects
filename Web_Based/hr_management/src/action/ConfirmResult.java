package action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import pojo.Applyvacancy;

import com.opensymphony.xwork2.ActionSupport;

import dao.ApplyVacancyDao;

public class ConfirmResult extends ActionSupport implements SessionAware
{

	private long appid;
	private String status;

	//private Applyvacancy vacancy=new Applyvacancy();
	private ApplyVacancyDao dao=null;
	private List<Applyvacancy> list;
	private Map map;
	
	
	@Override
	public String execute() throws Exception 
	{
		dao=new ApplyVacancyDao();
		//int eid=Integer.parseInt(((String)map.get("eid")));
		//System.out.println("map is "+eid);
		System.out.println(status+appid);
		dao.updateAppStatus(appid,status);
		//System.out.println("list is "+list.toString());
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
	
	public long getAppid() {
		return appid;
	}

	public void setAppid(long appid) {
		this.appid = appid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		System.out.println("in set");
		this.status = status;
	}

	

}
