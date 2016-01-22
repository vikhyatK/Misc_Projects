package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import pojo.Applicant;

import com.opensymphony.xwork2.ActionSupport;

import dao.ApplicantDao;

public class GetAppDetails extends ActionSupport implements SessionAware
{
	private ApplicantDao dao;
	private Applicant applicant;
	private long appid;
	private Map map;

	@Override
	public String execute() throws Exception  
	{
		dao=new ApplicantDao();
		appid=Long.parseLong((String) map.get("eid"));
		applicant =dao.viewapplicant(appid);
			//map.put("applicant", applicant);
			System.out.println(applicant.getEmail());
			return SUCCESS;
	}
	

	public Applicant getApplicant() {
		return applicant;
	}


	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}


	@Override
	public void setSession(Map arg0)
	{
		map=arg0;
		
	}

}
