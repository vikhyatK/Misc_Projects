package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import pojo.Applicant;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.ApplicantDao;

public class SearchApplicant extends ActionSupport implements SessionAware,ModelDriven<Applicant>
{
	private ApplicantDao dao;
	private Applicant applicant;
	private long appid;
	


	private Map map;

	@Override
	public String execute() throws Exception  
	{
		dao=new ApplicantDao();
		System.out.println("in action defore dao call"+getAppid());
		applicant =dao.viewapplicant(getAppid());
		if(applicant!=null)
		{
			map.put("appli", applicant);
			
			return SUCCESS;
		}
		else{
			//System.out.println("in else");
			this.addFieldError("appid","Applicant not Found");
			return INPUT;
		}
	}
	
	public long getAppid() {
		return appid;
	}





	public void setAppid(long appid) {
		this.appid = appid;
	}
	


	@Override
	public void setSession(Map arg0)
	{
		map=arg0;
		
	}


	@Override
	public Applicant getModel() 
	{
		
		return applicant;
	}

}
